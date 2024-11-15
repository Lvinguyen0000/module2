package Part1;

import java.util.Scanner;

public class NumberToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive interger number with three digits at most: ");
        int number = scanner.nextInt();

        if (number > 999 || number < 0) {
            System.out.println("Invalid input!");
        } else {
            int firstDigit = number / 100;
            int secondDigit = (number % 100) / 10;
            int thirdDigit = number % 10;
            String result = "";
            switch (firstDigit) {
                case 1:
                    result += "One ";
                    break;
                case 2:
                    result += "Two ";
                    break;
                case 3:
                    result += "Three ";
                    break;
                case 4:
                    result += "Four ";
                    break;
                case 5:
                    result += "Five ";
                    break;
                case 6:
                    result += "Six ";
                    break;
                case 7:
                    result += "Seven ";
                    break;
                case 8:
                    result += "Eight ";
                    break;
                case 9:
                    result += "Nine ";
                    break;
            }
            result += "hundred ";
            switch (secondDigit) {
                case 2:
                    result += "Twenty ";
                    break;
                case 3:
                    result += "Thirty ";
                    break;
                case 4:
                    result += "Fourty ";
                    break;
                case 5:
                    result += "Fifty ";
                    break;
                case 6:
                    result += "Sixty ";
                    break;
                case 7:
                    result += "Seventy ";
                    break;
                case 8:
                    result += "Eighty ";
                    break;
                case 9:
                    result += "Ninety ";
                    break;
            }
            if (secondDigit != 1 && secondDigit != 0) {
                switch (thirdDigit) {
                    case 1:
                        result += "One ";
                        break;
                    case 2:
                        result += "Two ";
                        break;
                    case 3:
                        result += "Three ";
                        break;
                    case 4:
                        result += "Four ";
                        break;
                    case 5:
                        result += "Five ";
                        break;
                    case 6:
                        result += "Six ";
                        break;
                    case 7:
                        result += "Seven ";
                        break;
                    case 8:
                        result += "Eight ";
                        break;
                    case 9:
                        result += "Nine ";
                        break;
                }
            }
            else if (secondDigit == 0 && thirdDigit != 0) {
                if (firstDigit != 0) result += "and ";
                switch (thirdDigit) {
                    case 1:
                        result += "One ";
                        break;
                    case 2:
                        result += "Two ";
                        break;
                    case 3:
                        result += "Three ";
                        break;
                    case 4:
                        result += "Four ";
                        break;
                    case 5:
                        result += "Five ";
                        break;
                    case 6:
                        result += "Six ";
                        break;
                    case 7:
                        result += "Seven ";
                        break;
                    case 8:
                        result += "Eight ";
                        break;
                    case 9:
                        result += "Nine ";
                        break;
                }
            }
            else {
                switch (thirdDigit) {
                    case 0:
                        result += "Ten ";
                        break;
                    case 1:
                        result += "Eleven ";
                        break;
                    case 2:
                        result += "Twelve ";
                        break;
                    case 3:
                        result += "Thirteen ";
                        break;
                    case 4:
                        result += "Fourteen ";
                        break;
                    case 5:
                        result += "Fifteen ";
                        break;
                    case 6:
                        result += "Sixteen ";
                        break;
                    case 7:
                        result += "Seventeen ";
                        break;
                    case 8:
                        result += "Eighteen ";
                        break;
                    case 9:
                        result += "Nineteen ";
                        break;
                }
            }
            System.out.println(result);
        }
    }
}