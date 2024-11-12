package Part1;

import java.util.Scanner;

public class BMICal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter weight(kg): ");
        double weight = scanner.nextDouble();
        System.out.print("Enter height(m): ");
        double height = scanner.nextDouble();
        double bmi = weight / (height * height);
        System.out.println("BMI: " + bmi);
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 25) {
            System.out.println("Normal");
        } else if (bmi < 30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }

}