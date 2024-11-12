package Part4.Rectangle.src;

public class Rectangle {
    double width, height;

    public Rectangle(){
        this.width = 100;
        this.height = 100;
    }

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public void setWidth (double width){this.width = width;}
    public void setHeight(double height){this.height = height;}

    public double getArea(){
        return this.width * this.height;
    }

    public double getPerimeter(){
        return (this.width + this.height) * 2;
    }

    public String display(){
        String display = "Rectangle{" + "width=" + width + ", height=" + height + "}\n";
        display += "Perimeter: " + this.getPerimeter() + "\n";
        display += "Area: " + this.getArea() + "\n";

        return display;
    }
}
