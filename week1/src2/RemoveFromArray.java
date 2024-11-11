import java.util.Scanner;
import java.util.stream.IntStream;

public class RemoveFromArray {
    public static int[] removeElement (int[] arr, int ele) {
        if (arr == null || arr.length == 0 || !IntStream.of(arr).anyMatch(x -> x == ele)) {
            return arr;
        }

        int[] tempArr = new int[arr.length - 1];

        for (int i = 0, j = 0; i < arr.length; i++, j++) {
            if (arr[i] == ele) {
                i++;
            }
            tempArr[j] = arr[i];
        }

        return tempArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println("Original array: " + java.util.Arrays.toString(arr));

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an element to remove: ");
        int ele = sc.nextInt();

        int[] newArr = removeElement(arr, ele);
        System.out.println("Array after removing " + ele + ": " + java.util.Arrays.toString(newArr));
    }
}