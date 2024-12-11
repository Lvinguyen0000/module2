package menu;

import management.UserService;
import utility.EmailHandler;
import utility.NumberGetter;

import java.util.Objects;
import java.util.Scanner;

public class GuestController {
    private static final Scanner sc = new Scanner(System.in);
    private static GuestController guestController = null;

    private GuestController(){}

    public static GuestController getInstance(){
        if (guestController == null){
            guestController = new GuestController();
        }
        return guestController;
    }

    public void showOptions(){
        int choice = -1;

        do{
            System.out.println("What do you need?");
            System.out.println("1. Choose a hotel from list");
            System.out.println("2. Go back");

            choice = NumberGetter.getInstance().getInt();

            switch(choice){
                case 1:
                    HotelController.getInstance().showHotelList(1, true, false);
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }while(choice != 2);
    }

    public void showForgotPassword(){
        System.out.println("Please enter your email address or back to go back");
        String email = sc.nextLine();

        if (Objects.equals(email, "back")) return;

        String tempData = UserService.getInstance().getUserByEmail(email);
        if (tempData != null){
            tempData = UserService.getInstance().getPasswordById(tempData.split(",")[0]);
            EmailHandler.getInstance().sendForgotPasswordAsync(email, tempData.split(",")[2]);
            System.out.println("Please check you email to recover password");
        }
        else{
            System.out.println("Email not found");
            showForgotPassword();
        }
    }

}
