package utility.fileIO;

import entities.LoginForm;
import entities.user.User;
import utility.Hash;

import java.io.*;
import java.util.Objects;

public class UserReadWriteFile extends ReadWriteFile {

    public static final String USER_INFO_PATH = System.getProperty("user.dir") + "\\data\\user\\user-info.txt";
    public static final String USER_LOGIN_PATH = System.getProperty("user.dir") + "\\data\\user\\login-info.txt";
    public static final String USER_FUND_PATH = System.getProperty("user.dir") + "\\data\\user\\fund-info.txt";

    private static UserReadWriteFile userReadWriteFile = null;

    private UserReadWriteFile(){}
    public static UserReadWriteFile getInstance(){
        if (userReadWriteFile == null){
            userReadWriteFile = new UserReadWriteFile();
        }
        return userReadWriteFile;
    }

    public boolean isUsernameExist(String username) {
        return findByString(USER_INFO_PATH, username) != null;
    }


    public String[] getUserDataFromFile(String id) {
        return Objects.requireNonNull(readLineById(USER_INFO_PATH, id)).split(",");
    }

    public String[] getLoginDataFromFile(LoginForm form) {
        try (BufferedReader br = new BufferedReader(new FileReader(Objects.requireNonNull(getFile(USER_LOGIN_PATH))))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.split(",")[1].equals(form.getUsername()) && line.split(",")[2].equals(Hash.generateSHA256Hash(form.getPassword()))) {
                    return line.split(",");
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file" + e.getMessage());
        }
        return null;
    }

    public long getUserFunding(String id){
        String line = readLineById(USER_FUND_PATH, id);
        try {
            if (line != null) {
                return Long.parseLong(line.split(",")[1]);
            }
        }
        catch (NumberFormatException e){
            System.out.println("Number error " + e.getMessage());
        }
        return 0;
    }

    public void writeLoginUserFile(String id, LoginForm form) {
        writeNewLineToFile(USER_LOGIN_PATH, id+","+form.exportToFile());
    }

    public void writeUserFile(String id, String name, String dob, String phone, String email, String address) {
        writeNewLineToFile(USER_INFO_PATH, id + "," + name + "," + dob + "," + phone + "," + email + "," + address + ",customer");
    }

    public void readAndWriteUserFundingFile(String id, long newFund) {
            if (newFund != 0) {
                String orgLine = readLineById(USER_FUND_PATH, id);
                long newMoney = newFund + Long.parseLong(orgLine.split(",")[1]);
                replaceById(USER_FUND_PATH, id, id + "," + newMoney);
            }

            else {
                writeNewLineToFile(USER_FUND_PATH, id + "," + newFund);
            }
    }

    public void readAndWriteUserInfo(User user){
        replaceById(USER_INFO_PATH, user.getId(), user.exportToFile());
    }

    public void readAndWriteLoginInfo(String id, LoginForm form){
        replaceById(USER_LOGIN_PATH, id, id+","+form.exportToFile());
    }

    public String getUserByString(String str){
        return findByString(USER_INFO_PATH, str);
    }

    public String getUserLoginById (String id){
        return readLineById(USER_LOGIN_PATH, id);
    }
}
