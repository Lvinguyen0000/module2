import utility.Hash;

import java.io.*;

import static utility.fileIO.ReadWriteFile.getFile;

public class HashPassword {
    public static final String USER_LOGIN_PATH = System.getProperty("user.dir") + "\\data\\user\\login-info.txt";
    public static final String TEMP_FILE_PATH = System.getProperty("user.dir") + "\\data\\temp-info.txt";

    public static void main(String[] args) {
        try{
            File readerFile = getFile(USER_LOGIN_PATH);
            File writerFile = getFile(TEMP_FILE_PATH);

            assert readerFile != null;
            BufferedReader br = new BufferedReader(new FileReader(readerFile));
            assert writerFile != null;
            BufferedWriter bw = new BufferedWriter(new FileWriter(writerFile));

            String line;

            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(",");
                splitLine[2] = Hash.generateSHA256Hash(splitLine[2]);

                bw.write(splitLine[0] + "," + splitLine[1] + "," + splitLine[2]);
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

    public static void delay(){
        try{
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
