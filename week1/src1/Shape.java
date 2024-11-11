import java.util.Scanner;

public class Shape {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the square");
            System.out.println("3. Draw the rectangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    String result = "";
                    for (int i = 1; i <= 7; i++) {
                        for (int j = 1; j <= i; j++) {
                            result += "* ";
                        }
                        result += "\n";
                    }
                    System.out.println("Draw the triangle");
                    System.out.println(result);
                    break;
                case 2:
                    String result1 = "";
                    for (int i = 1; i <= 7; i++) {
                        for (int j = 7; j >= i; j--) {
                            result1 += "* ";
                        }
                        result1 += "\n";
                    }
                    System.out.println("Draw the square");
                    System.out.println(result1);
                    break;
                case 3:
                    String result2 = "";
                    for (int i = 1; i <= 3; i++) {
                        for (int j = 0; j <= 7; j++) {
                            result2 += "* ";
                        }
                        result2 += "\n";
                    }
                    System.out.println("Draw the rectangle");
                    System.out.println(result2);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}