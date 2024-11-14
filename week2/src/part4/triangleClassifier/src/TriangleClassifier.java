public class TriangleClassifier {
    public String classifyTriangle(int[] sides) {
        if (sides.length < 3) {
            return "Invalid input";
        }

        if (sides[0] <= 0 || sides[1] <= 0 || sides[2] <= 0) {
            return "Not a triangle";
        } else if (checkEquilateral(sides)) {
            return "Equilateral triangle";
        } else if (checkIsosceles(sides)){
            return "Isosceles triangle";
        } else if (checkNormal(sides)){
            return "Normal triangle";
        }
        return "Not a triangle";
    }

    private boolean checkNormal(int[] sides) {
        return valid3Side(sides[0], sides[1], sides[2]) &&
                valid3Side(sides[0], sides[2], sides[1]) &&
                valid3Side(sides[1], sides[2], sides[0]);
    }

    private boolean checkIsosceles(int[] sides) {
        return equalSide(sides[0], sides[1]) ||
                equalSide(sides[0], sides[2]) ||
                equalSide(sides[1], sides[2]);
    }

    private boolean checkEquilateral(int[] sides) {
        return equalSide(sides[0], sides[1]) && equalSide(sides[0], sides[2]);
    }

    private boolean equalSide (int side1, int side2){
        return side1 == side2;
    }
    private boolean valid3Side (int side1, int side2, int side3){
        return side1 + side2 > side3;
    }
}
