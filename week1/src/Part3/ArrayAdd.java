package Part3;

import java.util.Scanner;

public class ArrayAdd {
    public static int[] addToArray(int[] arr, int num, int index) {
        int[] newArr = new int[arr.length + 1];
        for (int i = 0, j = 0; i < arr.length; i++, j++) {
            if (i == index) {
                newArr[j] = num;
                j++;
            }
            newArr[j] = arr[i];
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println("Original array: " + java.util.Arrays.toString(arr));

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an element to add: ");
        int num = sc.nextInt();

        System.out.println("Enter an index to add the element to: ");
        int index = sc.nextInt();

        if (index < 0 || index > arr.length) {
            System.out.println("Invalid index.");
            return;
        }

        int[] newArr = addToArray(arr, num, index);
        System.out.println("Array after adding " + num + " at index " + index + ": " + java.util.Arrays.toString(newArr));
    }
}