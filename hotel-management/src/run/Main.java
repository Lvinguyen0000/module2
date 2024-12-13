package run;

import utility.NumberGetter;
import utility.fileIO.ReadWriteFile;
import menu.GuestController;
import menu.UserController;
import entities.user.User;

import java.util.Scanner;

public class Main {
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to LVN");
        int choice = -1;

        while (choice != 0) {
            System.out.println("Please choose one of the following options:");
            System.out.println("1. Login");
            System.out.println("2. Register new user");
            System.out.println("3. Continue as guest");
            System.out.println("4. Forgot password");
            System.out.println("0. Exit");

            choice = NumberGetter.getInstance().getInt();

            switch (choice) {
                case 1:
                    User mainUser = UserController.getInstance().login();
                    if (mainUser != null) {
                        UserController.getInstance().showUserOption(mainUser);
                    }
                    break;
                case 2:
                    UserController.getInstance().register();
                    break;
                case 3:
                    GuestController.getInstance().showOptions();
                    break;
                case 4:
                    GuestController.getInstance().showForgotPassword();
                    break;
                case 0:
                    ReadWriteFile.shutdownExecutor();
                    break;
                default:
                    break;
            }
        }
    }
}

