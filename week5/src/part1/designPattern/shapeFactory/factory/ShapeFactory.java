package part1.designPattern.shapeFactory.factory;

import part1.designPattern.shapeFactory.shape.Circle;
import part1.designPattern.shapeFactory.shape.Rectangle;
import part1.designPattern.shapeFactory.shape.Shape;
import part1.designPattern.shapeFactory.shape.Square;

public class ShapeFactory {
    public Shape getShape(String type){
        if("circle".equals(type)) {
            return new Circle();
        }
        else if("Square".equals(type)){
            return new Square();
        }
        else if("Rectangle".equals(type)){
            return new Rectangle();
        }
        else return null;
    }
}
