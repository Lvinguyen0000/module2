package Part3;

import java.util.Scanner;

public class FindName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nameArr = {"Ann", "Bob", "Carl", "Dave"};

        System.out.print("Enter a name: ");
        String name = scanner.nextLine();
        for (int i = 0; i < nameArr.length; i++) {
            if (name.equals(nameArr[i])) {
                System.out.println("Found " + name + " at index " + i);
            }
        }
    }
}