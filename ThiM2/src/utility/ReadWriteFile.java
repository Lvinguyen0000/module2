package utility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadWriteFile {
    static String line;
    public static final String CONTACT_FILE_PATH = System.getProperty("user.dir") + "\\data\\contacts.csv";
    public static final String TEMP_FILE_PATH = System.getProperty("user.dir") + "\\data\\temp-info.txt";
    private static ReadWriteFile readWriteFile = null;

    private ReadWriteFile(){}

    public static ReadWriteFile getInstance(){
        if (readWriteFile == null){
            readWriteFile = new ReadWriteFile();
        }
        return readWriteFile;
    }


    public static File getFile() {
        try {
            File file = new File(CONTACT_FILE_PATH);
            file.createNewFile();

            if (!file.exists()) {
                throw new FileNotFoundException(CONTACT_FILE_PATH);
            }

            return file;
        } catch (IOException e) {
            System.out.println("File Not Found" + CONTACT_FILE_PATH);
        }
        return null;
    }

    public static List<String> readFile() {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(Objects.requireNonNull(getFile())))){

            line = br.readLine();

            while ((line = br.readLine()) != null) {
                result.add(line);
            }
            return result;
        } catch (IOException e) {
            System.out.println("Error reading file" + e.getMessage());
        }
        return null;
    }

    public static void writeNewLineToFile(String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Objects.requireNonNull(getFile()), true))){
            bw.write(content);
            bw.newLine();
        }
        catch (IOException e) {
            System.out.println("Error writing file" + e.getMessage());
        }
    }
}
