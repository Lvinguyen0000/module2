package Part2.ShapeOperation;

import Part2.ShapeOperation.Shape.Circle;
import Part2.ShapeOperation.Shape.Rectangle;
import Part2.ShapeOperation.Shape.Shape;
import Part2.ShapeOperation.Shape.Square;
import Part2.ShapeOperation.comparable.ComparableCircle;
import Part2.ShapeOperation.comparator.CircleComparator;
import Part2.ShapeOperation.resizeable.Resizeable;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ComparableCircle[] circles1 = new ComparableCircle[3];
        circles1[0] = new ComparableCircle(3.6);
        circles1[1] = new ComparableCircle();
        circles1[2] = new ComparableCircle(3.5, "indigo", false);

        System.out.println("Pre-sorted:");
        for (ComparableCircle circle : circles1) {
            System.out.println(circle);
        }

        Arrays.sort(circles1);

        System.out.println("After-sorted:");
        for (ComparableCircle circle : circles1) {
            System.out.println(circle);
        }

        Circle[] circles2 = new Circle[3];
        circles2[0] = new Circle(3.6);
        circles2[1] = new Circle();
        circles2[2] = new Circle(3.5, "indigo", false);

        System.out.println("Pre-sorted:");
        for (Circle circle : circles2) {
            System.out.println(circle);
        }

        Comparator circleComparator = new CircleComparator();
        Arrays.sort(circles2, circleComparator);

        System.out.println("After-sorted:");
        for (Circle circle : circles2) {
            System.out.println(circle);
        }

        Shape[] shapes = new Shape[6];
        shapes[0] = new Circle(20);
        shapes[1] = new Rectangle(10, 15);
        shapes[2] = new Square(30);
        shapes[3] = new Circle(50);
        shapes[4] = new Square(100);
        shapes[5] = new Rectangle(35, 20);
        for (Shape shape: shapes){
            Resizeable resizeable = null;
            if (shape instanceof Circle){
                resizeable = (Circle) shape;
            } else if (shape instanceof Square) {
                resizeable = (Square) shape;
            }
             else if (shape instanceof Rectangle) {
                resizeable = (Rectangle) shape;
            }
            assert resizeable != null;
            resizeable.resize(Math.random()*100);
            System.out.println(resizeable);
            if (shape instanceof Square){
                System.out.println(((Square) shape).howToColor());
            }
        }
    }
}
