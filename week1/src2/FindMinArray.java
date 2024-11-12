import java.util.Scanner;

public class FindMinArray {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter array size: ");
        int arrSize = scanner.nextInt();

        int[] arr = new int[arrSize];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println("Generated array: " + java.util.Arrays.toString(arr));

        System.out.println("Smallest element in array is: " + findMin(arr));
    }

    public static int findMin(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }
}