package part1.CircleCylinder;

public class Circle {
    private double radius = 1.0;
    private String color = "blue";

    public Circle(){}
    public Circle(double radius , String color){
        this.radius = radius;
        this.color = color;
    }

    public double getRadius(){return this.radius;}
    public void setRadius(double radius){
        this.radius = radius;
    }

    public String getColor(){return this.color;}
    public void setColor(String color){
        this.color = color;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }
    public  double getPerimeter(){
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString(){
        return "A " + this.getColor() + " Circle with radius " + this.getRadius();
    }
}
