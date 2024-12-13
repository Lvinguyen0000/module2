package menu;

import entities.LoginForm;
import management.UserService;
import utility.EmailHandler;
import utility.Hash;
import utility.NumberGetter;
import utility.StringGenerator;

import java.util.Objects;

import static run.Main.sc;

public class GuestController {
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
            tempData = UserService.getInstance().getLoginById(tempData.split(",")[0]);
            String newPassword = StringGenerator.generateRandomString();

            EmailHandler.getInstance().sendForgotPasswordAsync(email, newPassword);

            String[] currentLogin = tempData.split(",");
            UserService.getInstance().changeLoginInfo(currentLogin[0], new LoginForm(currentLogin[1], Hash.generateSHA256Hash(newPassword)));

            System.out.println("Please check you email to get new password");
        }
        else{
            System.out.println("Email not found");
            showForgotPassword();
        }
    }

}
