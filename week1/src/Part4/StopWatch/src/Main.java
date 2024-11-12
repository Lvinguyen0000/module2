package Part4.StopWatch.src;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StopWatch sw = new StopWatch();

        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) (Math.random() * 10000);
        }
        System.out.println("Original array: " + java.util.Arrays.toString(arr));
        sw.start();
        Arrays.sort(arr);
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
        sw.stop();
        System.out.println("Sort the array in: " + sw.getElapsedTime() + " millisecond");
    }
}
