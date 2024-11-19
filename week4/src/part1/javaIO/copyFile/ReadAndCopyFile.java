package part1.javaIO.copyFile;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class ReadAndCopyFile {
    public File sourceFile(String fileName) {
        try{
            File file = new File(fileName);

            if(!file.exists()){
                throw new FileNotFoundException(fileName);
            }

            return file;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public File targetFile(String fileName) {
        try{
            File file = new File(fileName);

            if(file.exists()){
                throw new FileAlreadyExistsException(fileName);
            }
            return file;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void copyFile(File sourceFile, File targetFile) throws IOException {
        try {
            FileReader fr = new FileReader(sourceFile);
            BufferedReader br = new BufferedReader(fr);

            PrintWriter pw = new PrintWriter(targetFile);

            String line;

            while ((line = br.readLine()) != null) {
                pw.println(line);
            }
            br.close();
            pw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ReadAndCopyFile readAndCopyFile = new ReadAndCopyFile();
        readAndCopyFile.copyFile(readAndCopyFile.sourceFile("src\\part1\\javaIO\\copyFile\\text.txt"), readAndCopyFile.targetFile("src\\part1\\javaIO\\copyFile\\result.txt"));
    }
}
