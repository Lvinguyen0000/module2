package Part3;

import java.util.Scanner;

public class PassingStudent {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of students: ");
        int size = scanner.nextInt();

        int[] gradeArr = new int[size];

        for (int i = 0; i < gradeArr.length; i++) {
            gradeArr[i] = (int) (Math.random() * 10);
        }
        System.out.println("Student's grade list: " + java.util.Arrays.toString(gradeArr));

        System.out.println("Number of passing students: "  + countPassing(gradeArr));
    }

    public static int countPassing (int[] gradeArr){
        int count = 0;
        for (int i = 0; i < gradeArr.length; i++){
            if (gradeArr[i] >= 5) count++;
        }

        return count;
    }
}