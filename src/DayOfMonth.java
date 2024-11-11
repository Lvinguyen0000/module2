import java.util.Scanner;

public class DayOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month: ");
        int month = scanner.nextInt();
        int day = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                break;
            case 2:
                day = 28;
                break;
            default:
                day = 0;
                break;
        }
        if (day != 0) {
            System.out.println("Day of month: " + day);
        } else {
            System.out.println("Invalid month!");
        }
    }
}