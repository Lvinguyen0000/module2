package Part4.Rectangle.src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Rectangle rect = new Rectangle(100, 200);
        System.out.println("Enter rectangle width: ");
        double width = sc.nextDouble();
        rect.setWidth(width);
        System.out.println("Enter rectangle height: ");
        double height = sc.nextDouble();
        rect.setHeight(height);
        System.out.println(rect.display());
    }
}