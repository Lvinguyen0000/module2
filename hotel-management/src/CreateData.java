import utility.fileIO.ReadWriteFile;

import java.io.*;

public class CreateData extends ReadWriteFile{
    public static final String USER_INFO_PATH = System.getProperty("user.dir") + "\\data\\user\\user-info.txt";
    public static final String USER_LOGIN_PATH = System.getProperty("user.dir") + "\\data\\user\\login-info.txt";
    public static final String USER_FUND_PATH = System.getProperty("user.dir") + "\\data\\user\\fund-info.txt";
    public static final String MOCK_DATA = System.getProperty("user.dir") + "\\data\\MOCK_DATA.txt";
    public static final String MOCK_DATA1 = System.getProperty("user.dir") + "\\data\\MOCK_DATA (1).txt";

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(MOCK_DATA1));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into fields based on comma
                String[] fields = line.split(",");

                // Assuming fields are: id, name, dob, phone, email, address, role, username, password, money
                if (fields.length >= 10) { // Check that we have enough fields
                    String id = fields[0].trim();
                    String name = fields[1].trim();
                    String dob = fields[2].trim();
                    String phone = fields[3].trim();
                    String email = fields[4].trim();
                    String address = fields[5].trim();
                    String role = fields[6].trim();
                    String username = fields[7].trim();
                    String password = fields[8].trim();
                    String money = fields[9].trim();

                    String loginInfo = String.join(",", id, username, password);
                    String userInfo = String.join(",", id, name, dob, phone, email, address, role);
                    String fundInfo = String.join(",", id, money);

                    writeNewLineToFile(USER_LOGIN_PATH, loginInfo);
                    writeNewLineToFile(USER_FUND_PATH, fundInfo);
                    writeNewLineToFile(USER_INFO_PATH, userInfo);

                } else {
                    System.err.println("Line does not have enough fields: " + line);
                }
            }

            System.out.println("Data has been successfully separated into three files.");
        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}
