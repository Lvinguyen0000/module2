package Part1.CircleCylinder;

public class Cylinder extends Circle{
    private double height = 2.0;

    public Cylinder(){}
    public Cylinder(double height){
        this.height = height;
    }
    public Cylinder(double height, double radius, String color){
        super(radius,color);
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        return super.getArea() * this.height;
    }

    public String toString() {
        return "A Cylinder with height= " + this.getHeight() + ", which is a subclass of " + super.toString();
    }
}
