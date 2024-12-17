package utility;

import utility.validation.ValidationFactory;

import java.util.Objects;
import java.util.Scanner;

public class InputGetter {
    private final static Scanner sc = new Scanner(System.in);
    private static InputGetter inputGetter = null;

    private InputGetter(){}

    public static InputGetter getInstance(){
        if (inputGetter == null){
            inputGetter = new InputGetter();
        }
        return inputGetter;
    }

    public int getInt(){
        int number = -1;
        try{
            number = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Please enter a number, not: " + e.getMessage());
            number = getInt();
        }
        return number;
    }

    public String getString(){
        String str = sc.nextLine();
        if (Objects.equals(str, "")){
            System.out.println("Please don't let the field empty");
            str = getString();
        }
        return str;
    }

    public String getPhoneNumber(){
        String phone = getString();

        if (!(new ValidationFactory().getValidation("phone").validate(phone))){
            System.out.println("Invalid phone number: 0#########");
            phone = getPhoneNumber();
        }
        return phone;
    }

    public String getEmail(){
        String email = getString();

        if (!(new ValidationFactory().getValidation("email").validate(email))){
            System.out.println("Invalid email");
            email = getEmail();
        }
        return email;
    }

}
