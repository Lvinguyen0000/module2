package validateClassName;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassNameExampleTest {

    @Test
    @DisplayName("Test C0223G")
    void validateClassName1() {
        ClassNameExample classNameExample = new ClassNameExample();
        String name = "C0223G";
        boolean expected = true;
        boolean actual = classNameExample.validateClassName(name);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test A0323K")
    void validateClassName2() {
        ClassNameExample classNameExample = new ClassNameExample();
        String name = "A0323K";
        boolean expected = true;
        boolean actual = classNameExample.validateClassName(name);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test M0318G")
    void validateClassName3() {
        ClassNameExample classNameExample = new ClassNameExample();
        String name = "M0318G";
        boolean expected = false;
        boolean actual = classNameExample.validateClassName(name);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test P0323A")
    void validateClassName4() {
        ClassNameExample classNameExample = new ClassNameExample();
        String name = "P0323A";
        boolean expected = false;
        boolean actual = classNameExample.validateClassName(name);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test A124987G")
    void validateClassName5() {
        ClassNameExample classNameExample = new ClassNameExample();
        String name = "A124987G";
        boolean expected = false;
        boolean actual = classNameExample.validateClassName(name);
        assertEquals(expected, actual);
    }
}