import java.util.Scanner;

public class RectOp {
    public static void main(String[] args) {
        float width;
        float height;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter width: ");
        width = scanner.nextFloat();

        System.out.print("Enter height: ");
        height = scanner.nextFloat();

        System.out.println("The area of the rectangle is " + width * height);
    }
}