package Part1;

import java.util.Scanner;

public class UsdToVnd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter USD: ");
        double usd = scanner.nextDouble();
        double vnd = usd * 23000;
        System.out.println("VND = " + vnd + " VND");
    }
}