package management;

import utility.fileIO.UserReadWriteFile;
import entities.LoginForm;
import entities.user.*;

public class UserService {
    public static final UserReadWriteFile USER_READ_WRITE_FILE = UserReadWriteFile.getInstance();
    private static UserService userService = null;

    private UserService(){}

    public static UserService getInstance(){
        if (userService == null){
            userService = new UserService();
        }
        return userService;
    }

    public User getUser(LoginForm loginForm){
        String[] loginDataArray = USER_READ_WRITE_FILE.getLoginDataFromFile(loginForm);
        if (loginDataArray != null){
            return createUser(loginDataArray[0]);
        }
        return null;
    }

    private User createUser(String id){
        String[] userDataArray = USER_READ_WRITE_FILE.getUserDataFromFile(id);
        if (userDataArray != null){
            return UserFactory.getUser(userDataArray);
        }
        return null;
    }

    public void addFund(String id, long newFund){
        USER_READ_WRITE_FILE.readAndWriteUserFundingFile(id, newFund);
    }

    public void changeUserInformation(User user){
        USER_READ_WRITE_FILE.readAndWriteUserInfo(user);
    }

    public void changeLoginInfo(String id, LoginForm form){
        String[] currentLogin = USER_READ_WRITE_FILE.getUserLoginById(id).split(",");
        if (form.getUsername() == null){
            form.setUsername(currentLogin[1]);
        }
        if (form.getPassword() == null){
            form.setPassword(currentLogin[2]);
        }

        USER_READ_WRITE_FILE.readAndWriteLoginInfo(id, form);
    }

    public String getUserByEmail(String email){
        return USER_READ_WRITE_FILE.getUserByString(email);
    }

    public String getLoginById(String id){
        return USER_READ_WRITE_FILE.getUserLoginById(id);
    }
}
