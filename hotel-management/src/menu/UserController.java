package menu;

import utility.Hash;
import utility.NumberGetter;
import utility.fileIO.UserReadWriteFile;
import management.RegisterUser;
import management.UserService;
import utility.validation.ValidationFactory;
import entities.LoginForm;
import entities.user.Partner;
import entities.user.User;

import java.util.Objects;

import static run.Main.sc;

public class UserController {
    public static final long PARTNERSHIP_FEE = 500000;
    public static final ValidationFactory VALIDATION_FACTORY = new ValidationFactory();
    public static final UserService USER_SERVICE = UserService.getInstance();
    public static final UserReadWriteFile USER_READ_WRITE_FILE = UserReadWriteFile.getInstance();
    private static UserController userController = null;

    private UserController() {}

    public static UserController getInstance() {
        if (userController == null) {
            userController = new UserController();
        }
        return userController;
    }

    public User login() {
        User user = getUserFromInput();

        int choice = -1;

        while ((choice != 1 || choice != 2) && user == null) {
            System.out.println("Wrong username or password\nChoose one of the following options:");
            System.out.println("1. Login");
            System.out.println("2. Go back to main menu");

            choice = NumberGetter.getInstance().getInt();

            switch (choice) {
                case 1:
                    return login();
                case 2:
                    return null;
                default:
                    break;
            }
        }
        return user;
    }

    private User getUserFromInput() {
        System.out.println("Please enter your username");
        String username = sc.nextLine();
        System.out.println("Please enter your password");
        String password = sc.nextLine();
        return USER_SERVICE.getUser(new LoginForm(username, password));
    }

    public void register() {
        String str = USER_SERVICE.getRegisterInformation();

        if (RegisterUser.getInstance().checkRegisterInformation(str)) {
            System.out.println("Register successful");
        } else {
            System.out.println("Register failed");
        }
    }

    public void showUserOption(User user) {
        System.out.println("Hello " + user.getName());
        int choice = -1;

        do {
            System.out.println("Please choose one of the following options:");
            System.out.println("1. See hotel");
            System.out.println("2. Check booking information");
            System.out.println("3. Check account information");
            System.out.println("4. Logout");

            choice = NumberGetter.getInstance().getInt();

            switch (choice) {
                case 1:
                    HotelController hc = HotelController.getInstance();
                    hc.setCurrentUser(user);
                    hc.hotelMainScreen();
                    break;
                case 2:
                    BookingController bc = BookingController.getInstance();
                    bc.setCurrentUser(user);
                    bc.showUserBookingOption();
                    break;
                case 3:
                    showAccountInformation(user);
                    break;
                case 4:
                    user = null;
                    break;
                default:
                    break;
            }
        }
        while (choice != 4);
    }

    private void showAccountInformation(User user) {
        int choice = -1;
        System.out.println(user);
        do {
            System.out.println("1. Change account information");
            System.out.println("2. Check funding");
            System.out.println("3. Check partnership status");
            System.out.println("4. Go back to main menu");

            choice = NumberGetter.getInstance().getInt();

            switch (choice) {
                case 1:
                    changeAccountInformation(user);
                    break;
                case 2:
                    checkFunding(user);
                    break;
                case 3:
                    checkPartnership(user);
                    break;
                default:
                    break;
            }
        }
        while (choice != 4);
    }

    private void changeAccountInformation(User user) {
        String tempUserName = null, tempPassword = null;
        int choice = -1;
        StringBuilder sb = new StringBuilder();

        boolean commonInfoChanged = false;
        boolean userNameOrPasswordChanged = false;

        do {
            System.out.println("1. Change name");
            System.out.println("2. Change date of birth");
            System.out.println("3. Change phone number");
            System.out.println("4. Change email");
            System.out.println("5. Change address");
            System.out.println("6. Change username");
            System.out.println("7. Change password");
            System.out.println("0. Go back");

            choice = NumberGetter.getInstance().getInt();

            switch (choice) {
                case 1:
                    USER_SERVICE.getName(sb);
                    user.setName(sb.toString());
                    sb = new StringBuilder();
                    commonInfoChanged = true;
                    break;
                case 2:
                    USER_SERVICE.getDob(sb);
                    user.setDob(sb.toString());
                    sb = new StringBuilder();
                    commonInfoChanged = true;
                    break;
                case 3:
                    USER_SERVICE.getPhoneNumber(sb);
                    user.setPhoneNumber(sb.toString());
                    sb = new StringBuilder();
                    commonInfoChanged = true;
                    break;
                case 4:
                    USER_SERVICE.getEmail(sb);
                    user.setEmail(sb.toString());
                    sb = new StringBuilder();
                    commonInfoChanged = true;
                    break;
                case 5:
                    USER_SERVICE.getAddress(sb);
                    user.setAddress(sb.toString());
                    sb = new StringBuilder();
                    commonInfoChanged = true;
                    break;
                case 6:
                    USER_SERVICE.getUserName(sb);
                    tempUserName = sb.toString();
                    sb = new StringBuilder();
                    userNameOrPasswordChanged = true;
                    break;
                case 7:
                    USER_SERVICE.getPassword(sb);
                    tempPassword = Hash.generateSHA256Hash(sb.toString());
                    sb = new StringBuilder();
                    userNameOrPasswordChanged = true;
                    break;
                default:
                    break;
            }
        }
        while (choice != 0);

        if (commonInfoChanged) {
            USER_SERVICE.changeUserInformation(user);
        }
        if (userNameOrPasswordChanged) {
            USER_SERVICE.changeLoginInfo(user.getId(), new LoginForm(tempUserName, tempPassword));
        }
    }

    public void checkFunding(User user) {
        int choice = -1;

        do {
            System.out.println("Your current funding: " + USER_READ_WRITE_FILE.getUserFunding(user.getId()));
            System.out.println("1. Add funding");
            System.out.println("2. Go back");

            choice = NumberGetter.getInstance().getInt();

            if (choice == 1) {
                addFunding(user);
            }
        }
        while (choice != 2);
    }

    private void addFunding(User user) {
        System.out.println("Enter the amount for adding: ");
        USER_SERVICE.addFund(user.getId(), NumberGetter.getInstance().getLong());
    }

    private void checkPartnership(User user) {
        String currentRole = user.getRole();

        if (!Objects.equals(currentRole, "partner")) {
            long fund = USER_READ_WRITE_FILE.getUserFunding(user.getId());
            System.out.println("You currently not a partner");
            System.out.println("Your current funding: " + fund);
            System.out.println("1. Upgrade to partner(" + PARTNERSHIP_FEE + ")");
            System.out.println("2. Go back");

            if (NumberGetter.getInstance().getInt() == 1 && fund > PARTNERSHIP_FEE) {
                user.setRole("partner");
                user = new Partner(user);
                USER_SERVICE.addFund(user.getId(), -PARTNERSHIP_FEE);
                USER_SERVICE.changeUserInformation(user);
            }
        } else {
            System.out.println("Already a partner");
        }
    }
}
