import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

    @Test
    @DisplayName("Test 1")
    void testClassifyTriangle1() {
        TriangleClassifier classifier = new TriangleClassifier();
        int[] testSide = {2, 2, 2};

        String expected = "Equilateral triangle";
        String actual = classifier.classifyTriangle(testSide);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test 2")
    void testClassifyTriangle2() {
        TriangleClassifier classifier = new TriangleClassifier();
        int[] testSide = {2, 2, 3};

        String expected = "Isosceles triangle";
        String actual = classifier.classifyTriangle(testSide);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test 3")
    void testClassifyTriangle3() {
        TriangleClassifier classifier = new TriangleClassifier();
        int[] testSide = {3, 4, 5};

        String expected = "Normal triangle";
        String actual = classifier.classifyTriangle(testSide);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test 4")
    void testClassifyTriangle4() {
        TriangleClassifier classifier = new TriangleClassifier();
        int[] testSide = {8, 2, 3};

        String expected = "Not a triangle";
        String actual = classifier.classifyTriangle(testSide);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test 5")
    void testClassifyTriangle5() {
        TriangleClassifier classifier = new TriangleClassifier();
        int[] testSide = {-1, 2, 1};

        String expected = "Not a triangle";
        String actual = classifier.classifyTriangle(testSide);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test 6")
    void testClassifyTriangle6() {
        TriangleClassifier classifier = new TriangleClassifier();
        int[] testSide = {0, 1, 1};

        String expected = "Not a triangle";
        String actual = classifier.classifyTriangle(testSide);
        assertEquals(expected, actual);
    }
}