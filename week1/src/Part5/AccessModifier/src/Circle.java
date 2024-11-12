package Part5.AccessModifier.src;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {}
    public Circle(double radius) {
        this.radius = radius;
    }

    private double getRadius() {
        return this.radius;
    }

    public double getArea(){
        return this.radius * this.radius * Math.PI;
    }
}
