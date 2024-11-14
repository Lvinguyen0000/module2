package part1.Shape;

public class Square extends Rectangle {
    public Square(){}
    public Square(double side){
        super(side,side);
    }
    public Square(double side, String color, boolean filled){
        super(side,side,color,filled);
    }
    public double getSide(){return super.getWidth();}
    public void setSide(double side){
        super.setWidth(side);
        super.setHeight(side);
    }

    @Override
    public void setWidth(double width){
        this.setSide(width);
    }

    @Override
    public void setHeight(double height){
        this.setSide(height);
    }

    @Override
    public String toString(){
        return "A Square with side= " + this.getSide() + ", which is a subclass of " + super.toString();
    }
}
