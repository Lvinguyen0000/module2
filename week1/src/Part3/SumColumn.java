package Part3;

import java.util.Scanner;

public class SumColumn{
    public static void main(String[] args){
        int[][] matrix = new int[5][5];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 100);
            }
            System.out.println(java.util.Arrays.toString(matrix[i]));
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter column index to calculate sum: ");
        int index = sc.nextInt();

        System.out.println("Sum of column " + index + " is: " + columnSum(matrix, index));
    }

    public static int columnSum(int[][] matrix, int index){
        int sum = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (j == index) sum += matrix[i][j];
            }
        }
        return sum;
    }
}