package Part4.Fan.src;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();

        fan1.setOn();
        fan1.setSpeed(3);
        fan1.setColor("yellow");
        fan1.setRadius(10);

        fan2.setSpeed(2);
        fan2.setColor("blue");
        fan2.setRadius(5);

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
