package part4.selectionSort;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(double[] list){
        for (int i = 0; i < list.length; i++) {
            int min = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[min]) {
                    min = j;
                }
            }
            if (min != i) {
                double temp = list[i];
                list[i] = list[min];
                list[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};
        System.out.println(Arrays.toString(list));
        selectionSort(list);
        System.out.println(Arrays.toString(list));

    }
}
