package utility.fileIO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.stream.Stream;

public abstract class ReadWriteFile {
    static String line;
    public static final String TEMP_FILE_PATH = System.getProperty("user.dir") + "\\data\\temp-info.txt";
    private static final ExecutorService executor = Executors.newFixedThreadPool(4);
    private static final int NUMBER_OF_THREADS = 4;
    private static volatile boolean found = false;
    private static String foundLine = null;
    private boolean lineFound = false;

    private static boolean containsString(String[] array, String target) {
        // Sort the array first
        Arrays.sort(array);
        // Perform binary search
        return Arrays.binarySearch(array, target) >= 0;
    }

    public static void deleteIfExist(String fileName){
        File file = new File(fileName);

        if (file.exists()){
            file.delete();
        }
    }

    public static File getFile(String fileName) {
        try {
            File file = new File(fileName);
            file.createNewFile();

            if (!file.exists()) {
                throw new FileNotFoundException(fileName);
            }

            return file;
        } catch (IOException e) {
            System.out.println("File Not Found" + fileName);
        }
        return null;
    }

    public static String readFile(String fileName) {
        StringBuilder result = new StringBuilder();
        try {

                FileReader fileReader = new FileReader(Objects.requireNonNull(UserReadWriteFile.getFile(fileName)));
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while ((line = bufferedReader.readLine()) != null) {
                    result.append(line);
                }
                bufferedReader.close();

            return result.toString();
        } catch (IOException e) {
            System.out.println("Error reading file" + e.getMessage());
        }
        return null;
    }

    public String findByString(String fileName, String parameter){
        return readLineById(fileName, parameter);
    }

    //TODO: readLineById solution 1 (the function that run sequence)
//    public static String readLineById(String fileName, String id) {
//        try (BufferedReader br = new BufferedReader(new FileReader(Objects.requireNonNull(getFile(fileName))))){
//            String line;
//            while ((line = br.readLine()) != null) {
//                if (containsString(line.split(","), id)) {
//                    return line;
//                }
//            }
//        }
//        catch (IOException e) {
//            System.out.println("Error reading file" + e.getMessage());
//        }
//        return null;
//    }

    //TODO: readLineById solution 2 (the function that run parallel -> improve performance)
    public static String readLineById(String fileName, String id) {
        long lineCount;
        try (Stream<String> stream = Files.lines(Path.of(fileName), StandardCharsets.UTF_8)) {
            lineCount = stream.count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int linesPerThread = (int) Math.ceil((double) lineCount / NUMBER_OF_THREADS);
        Future<String>[] futures = new Future[NUMBER_OF_THREADS];

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            final int threadIndex = i;
            futures[i] = executor.submit(() -> {
                try (BufferedReader br = new BufferedReader(new FileReader(Objects.requireNonNull(getFile(fileName))))) {
                    // Skip lines for this thread
                    br.lines().skip(threadIndex * linesPerThread).limit(linesPerThread).forEach(line -> {
                        if (!found && containsString(line.split(","), id)) {
                            foundLine = line; // Store the found line
                            found = true; // Set the flag to true
                        }
                    });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return foundLine;
            });
        }

        // Wait for the first thread to complete
        for (Future<String> future : futures) {
            try {
                if (found) {
                    break; // Stop checking if found
                }
                future.get(); // Wait for the thread to finish
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        found = false;
        String tempLine = foundLine;
        foundLine = null;
        return tempLine; // Return the found line or null if not found
    }

    public static void writeNewLineToFile(String fileName, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Objects.requireNonNull(getFile(fileName)), true))){
            bw.write(content);
            bw.newLine();
        }
        catch (IOException e) {
            System.out.println("Error writing file" + e.getMessage());
        }
    }

    public static void replaceById(String fileName, String id, String content) {
        try{
            File readerFile = getFile(fileName);
            File writerFile = getFile(TEMP_FILE_PATH);

            assert readerFile != null;
            BufferedReader br = new BufferedReader(new FileReader(readerFile));
            assert writerFile != null;
            BufferedWriter bw = new BufferedWriter(new FileWriter(writerFile));

            while ((line = br.readLine()) != null) {
                if (containsString(line.split(","), id)) {
                    bw.write(content);
                }
                else{
                    bw.write(line);
                }
                bw.newLine();
            }

            br.close();
            bw.close();

            readerFile.delete();
            delay();
            writerFile.renameTo(readerFile);

        }
        catch (IOException e) {
            System.out.println("Error reading or writting file" + e.getMessage());
        }
    }

    public static List<String> readLinesToPageFromFile(String fileName, int maxLine, int page){
        List<String> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(Objects.requireNonNull(getFile(fileName))))){
            int pageTraversed = 1;
            while ((line = br.readLine()) != null){
                if (list.size() == maxLine){
                    if (pageTraversed == page){
                        return list;
                    }
                    list.clear();
                    pageTraversed++;
                }
                list.add(line);
            }
        }
        catch (IOException e){
            System.out.println("Error reading file" + e.getMessage());
        }
        return list;
    }

    public static List<String> readLinesToPageFormFileById(String fileName, int maxLine, int page, String id){
        List<String> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(Objects.requireNonNull(getFile(fileName))))){
            int pageTraversed = 1;
            while ((line = br.readLine()) != null){
                if (containsString(line.split(","), id)) {
                    if (list.size() == maxLine){
                        if (pageTraversed == page){
                            return list;
                        }
                        list.clear();
                        pageTraversed++;
                    }
                    list.add(line);
                }
            }
        }
        catch (IOException e){
            System.out.println("Error reading file" + e.getMessage());
        }
        return list;
    }

    public boolean deleteById(String fileName, String id) {
        long lineCount;
        try (Stream<String> stream = Files.lines(Path.of(fileName))) {
            lineCount = stream.count();
        } catch (IOException e) {
            System.out.println("Error counting lines: " + e.getMessage());
            return false;
        }

        int linesPerThread = (int) Math.ceil((double) lineCount / NUMBER_OF_THREADS);
        Future<Boolean>[] futures = new Future[NUMBER_OF_THREADS];
        File writerFile = getFile(TEMP_FILE_PATH);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(writerFile))) {
            for (int i = 0; i < NUMBER_OF_THREADS; i++) {
                final int threadIndex = i;
                futures[i] = executor.submit(() -> {
                    try (BufferedReader br = new BufferedReader(new FileReader(Objects.requireNonNull(getFile(fileName))))) {
                        // Skip lines for this thread
                        br.lines().skip(threadIndex * linesPerThread).limit(linesPerThread).forEach(line -> {
                            if (!containsString(line.split(","), id)) {
                                synchronized (bw) { // Synchronize access to the BufferedWriter
                                    try {
                                        bw.write(line);
                                        bw.newLine();
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            } else {
                                lineFound = true; // Mark that a line was found
                            }
                        });
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    return lineFound;
                });
            }

            // Check if any thread found the line
            boolean lineFound = false;
            for (Future<Boolean> future : futures) {
                try {
                    lineFound |= future.get(); // Aggregate results from all threads
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // Rename the temporary file to the original file
            File readerFile = getFile(fileName);
            readerFile.delete();
            delay();
            writerFile.renameTo(readerFile);

            return lineFound; // Return true if any line was found and deleted
        } catch (IOException e) {
            System.out.println("Error writing temporary file: " + e.getMessage());
            return false;
        }
    }

    public List<String> getAllLinesById(String fileName, String id) {
        List<String> resultList = new CopyOnWriteArrayList<>(); // Thread-safe list to collect results
        long lineCount;

        // Count lines in the file
        try (Stream<String> stream = Files.lines(Path.of(fileName))) {
            lineCount = stream.count();
        } catch (IOException e) {
            System.out.println("Error counting lines: " + e.getMessage());
            return resultList;
        }

        int linesPerThread = (int) Math.ceil((double) lineCount / NUMBER_OF_THREADS);
        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            final int threadIndex = i;
            futures.add(executor.submit(() -> {
                try (BufferedReader br = new BufferedReader(new FileReader(Objects.requireNonNull(getFile(fileName))))) {
                    // Skip lines for this thread
                    br.lines().skip(threadIndex * linesPerThread).limit(linesPerThread).forEach(line -> {
                        if (containsString(line.split(","), id)) {
                            resultList.add(line); // Add matching lines to the list
                        }
                    });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }));
        }

        // Wait for all threads to complete
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (Exception e) {
                System.out.println("Error waiting for thread: " + e.getMessage());
            }
        }

        return resultList; // Return the collected results
    }

    public static void shutdownExecutor() {
        executor.shutdownNow();
    }

    public static void delay(){
        try{
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
