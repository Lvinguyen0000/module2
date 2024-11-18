package part4.insertionSort;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(double[] list) {
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j > 0; j--) {
                if (list[j] < list[j-1]) {
                    double temp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5, 5.2, 12.5, -51.5, 46.41};
        System.out.println(Arrays.toString(list));
        insertionSort(list);
        System.out.println(Arrays.toString(list));
    }
}
