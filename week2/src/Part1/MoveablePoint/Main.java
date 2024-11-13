package Part1.MoveablePoint;

public class Main {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint(2.0f, 3.0f);
        System.out.println(moveablePoint);
        moveablePoint.move();
        System.out.println(moveablePoint);
        moveablePoint.move();
        moveablePoint.move();
        System.out.println(moveablePoint);
    }
}
