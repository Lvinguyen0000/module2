package part5.illegalTriangleException;

public class TriangleExample {
    private void checkTriangle (double side1, double side2, double side3) throws Exception{
        if (side1 <= 0 || side2 <= 0 || side3 <= 0 ||
        side1 + side2 < side3 || side1 + side3 < side2 || side2 + side3 < side1){
            throw new Exception("Invalid triangle");
        }
        else {
            System.out.println("Valid triangle");
        }
    }

    public static void main (String[] args) {
        try{
            TriangleExample t = new TriangleExample();
            t.checkTriangle(-2, 3, 5);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
