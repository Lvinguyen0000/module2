package part1.javaIO.readCSV;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFile {
    public void readCSVFile(String fileName) {
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        } catch (IOException e) {
            System.err.println("Error reading file: " + fileName);
        }
    }

    public static void main(String[] args) {
        ReadCSVFile r = new ReadCSVFile();
        r.readCSVFile("src\\part1\\javaIO\\readCSV\\countries.csv");
    }
}
