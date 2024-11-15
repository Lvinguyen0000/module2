package part1.reverseWithStack;

public class StackTest {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println("Original array: " + java.util.Arrays.toString(arr));

        Stack<Object> stack = new Stack<>();
        for (int element : arr) {
            stack.push(element);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) stack.pop();
        }
        System.out.println("After pop: " + java.util.Arrays.toString(arr));
    }
}
