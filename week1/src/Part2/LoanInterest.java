package Part2;

import java.util.Scanner;

public class LoanInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter loan amount: ");
        double loanAmount = scanner.nextDouble();
        System.out.print("Enter interest rate per month: ");
        double interestRate = scanner.nextDouble();
        System.out.print("Enter number of months: ");
        int months = scanner.nextInt();
        double interest = loanAmount * (interestRate / 100) * months;
        System.out.println("The interest is " + interest);
    }
}