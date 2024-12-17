package service;

import utility.Hash;
import utility.fileIO.UserReadWriteFile;
import entities.LoginForm;

public class RegisterUserService {
    public static final UserReadWriteFile USER_READ_WRITE_FILE = UserReadWriteFile.getInstance();
    private static RegisterUserService registerUserService = null;

    private RegisterUserService(){}

    public static RegisterUserService getInstance(){
        if (registerUserService == null){
            registerUserService = new RegisterUserService();
        }
        return registerUserService;
    }

    public boolean checkRegisterInformation(String information){
        //name, dob, phone, email, address, username, password
        information = information.trim();
        String[] infoArray = information.split(",");

        if (USER_READ_WRITE_FILE.isUsernameExist(infoArray[5])) return false;

        addNewUser(infoArray);
        return true;
    }

    private static void addNewUser(String[] infoArray) {
        String id = Hash.generateMD5Hash(infoArray[5] + infoArray[6]);

        USER_READ_WRITE_FILE.writeLoginUserFile(id , new LoginForm(infoArray[5], Hash.generateSHA256Hash(infoArray[6])));
        USER_READ_WRITE_FILE.writeUserFile(id, infoArray[0], infoArray[1], infoArray[2], infoArray[3], infoArray[4]);
        USER_READ_WRITE_FILE.readAndWriteUserFundingFile(id, 0);
    }
}
