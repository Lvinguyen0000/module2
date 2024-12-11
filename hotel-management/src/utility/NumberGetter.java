package utility;

import java.util.Scanner;

public class NumberGetter {
    private Scanner sc = new Scanner(System.in);
    private static NumberGetter numberGetter = null;

    private NumberGetter(){}

    public static NumberGetter getInstance(){
        if (numberGetter == null){
            numberGetter = new NumberGetter();
        }
        return numberGetter;
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

    public long getLong(){
        long number = -1;
        try{
            number = Long.parseLong(sc.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Please enter a number, not: " + e.getMessage());
            number = getLong();
        }
        return number;
    }
}
