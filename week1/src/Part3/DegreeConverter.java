package Part3;

import java.util.Scanner;

public class DegreeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu.");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter a temperature in Fahrenheit: ");
                    float fahrenheit = scanner.nextFloat();
                    float celsius = fahrenheitToCelsius(fahrenheit);
                    System.out.println(fahrenheit + " degrees Fahrenheit is " + celsius + " degrees Celsius.");
                    break;
                case 2:
                    System.out.println("Enter a temperature in Celsius: ");
                    float celsius1 = scanner.nextFloat();
                    float fahrenheit1 = celsiusToFahrenheit(celsius1);
                    System.out.println(celsius1 + " degrees Celsius is " + fahrenheit1 + " degrees Fahrenheit.");
                    break;
                case 0:
                    System.out.println("Exit the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while (choice != 0);
    }

    public static float celsiusToFahrenheit(float celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static float fahrenheitToCelsius(float fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}