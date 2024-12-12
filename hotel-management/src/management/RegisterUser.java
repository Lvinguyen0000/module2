package management;

import utility.Hash;
import utility.fileIO.UserReadWriteFile;
import entities.LoginForm;

public class RegisterUser {
    public static final UserReadWriteFile USER_READ_WRITE_FILE = UserReadWriteFile.getInstance();
    private static RegisterUser registerUser = null;

    private RegisterUser(){}

    public static RegisterUser getInstance(){
        if (registerUser == null){
            registerUser = new RegisterUser();
        }
        return registerUser;
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
