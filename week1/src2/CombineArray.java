public class CombineArray {
    public static int[] combineArrays(int[] arr1, int[] arr2) {
        int[] combined = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            combined[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            combined[arr1.length + i] = arr2[i];
        }
        return combined;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[3];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (int) (Math.random() * 100);
        }
        System.out.println("First array: " + java.util.Arrays.toString(arr1));
        int[] arr2 = new int[5];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (int) (Math.random() * 100);
        }
        System.out.println("Second array: " + java.util.Arrays.toString(arr2));

        int[] combined = combineArrays(arr1, arr2);
        System.out.println("Combined array: " + java.util.Arrays.toString(combined));
    }
}