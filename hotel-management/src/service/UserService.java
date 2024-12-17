package service;

import utility.fileIO.UserReadWriteFile;
import entities.LoginForm;
import entities.user.*;

import static run.Main.sc;
import static controller.UserController.VALIDATION_FACTORY;

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

    public void getPassword(StringBuilder stringBuilder) {
        String password;
        do {
            System.out.println("Please enter your password");
            password = sc.nextLine();
        }
        while (!(VALIDATION_FACTORY.getValidation("password").validate(password)));
        stringBuilder.append(password);
    }

    public void getUserName(StringBuilder stringBuilder) {
        System.out.println("Please enter your username");
        stringBuilder.append(sc.nextLine());
    }

    public void getAddress(StringBuilder stringBuilder) {
        System.out.println("Please enter your address");
        stringBuilder.append(sc.nextLine());
    }

    public void getEmail(StringBuilder stringBuilder) {
        String email;
        do {
            System.out.println("Please enter your email");
            email = sc.nextLine();
        }
        while (!(VALIDATION_FACTORY.getValidation("email").validate(email)));
        stringBuilder.append(email);
    }

    public void getPhoneNumber(StringBuilder stringBuilder) {
        String number;
        do {
            System.out.println("Please enter phone number");
            number = sc.nextLine();
        }
        while (!(VALIDATION_FACTORY.getValidation("phone").validate(number)));
        stringBuilder.append(number);
    }

    public void getDob(StringBuilder stringBuilder) {
        String dob;
        do {
            System.out.println("Please enter date of birth");
            dob = sc.nextLine();
        }
        while (!(VALIDATION_FACTORY.getValidation("dob").validate(dob)));
        stringBuilder.append(dob);
    }

    public void getName(StringBuilder stringBuilder) {
        System.out.println("Please enter your name");
        stringBuilder.append(sc.nextLine());
    }

    public String getRegisterInformation() {
        StringBuilder stringBuilder = new StringBuilder();

        getName(stringBuilder);
        stringBuilder.append(",");
        getDob(stringBuilder);
        stringBuilder.append(",");
        getPhoneNumber(stringBuilder);
        stringBuilder.append(",");
        getEmail(stringBuilder);
        stringBuilder.append(",");
        getAddress(stringBuilder);
        stringBuilder.append(",");
        getUserName(stringBuilder);
        stringBuilder.append(",");
        getPassword(stringBuilder);
        return stringBuilder.toString();
    }
}
