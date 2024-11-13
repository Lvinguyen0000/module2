package Part1.Shape;

public class Rectangle extends Shape {
    private double width = 1.0;
    private double height = 1.0;

    public Rectangle(){}

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    public Rectangle (double width, double height, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public  double getWidth(){return this.width;}
    public  void setWidth(double width){
        this.width = width;
    }
    public  double getHeight(){return this.height;}
    public void setHeight(double height){
        this.height = height;
    }

    public double getArea(){
        return this.width * this.height;
    }
    public  double getPerimeter(){
        return (this.width + this.height) * 2;
    }

    @Override
    public String toString(){
        return "A Rectangle with width= " + this.getWidth() + " and height= " + this.getHeight() + ", which is a subclass of " + super.toString();
    }
}
