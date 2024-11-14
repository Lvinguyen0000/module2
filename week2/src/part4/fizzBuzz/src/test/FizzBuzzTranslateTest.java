import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTranslateTest {

    @Test
    @DisplayName("Test 1")
    void testTranslate1() {
        FizzBuzzTranslate fizzBuzzTranslate = new FizzBuzzTranslate();
        int number = 1;

        String expected = "One";
        String result =  fizzBuzzTranslate.translate(number);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test 2")
    void testTranslate2() {
        FizzBuzzTranslate fizzBuzzTranslate = new FizzBuzzTranslate();
        int number = 3;

        String expected = "Fizz";
        String result =  fizzBuzzTranslate.translate(number);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test 3")
    void testTranslate3() {
        FizzBuzzTranslate fizzBuzzTranslate = new FizzBuzzTranslate();
        int number = 5;

        String expected = "Buzz";
        String result =  fizzBuzzTranslate.translate(number);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test 4")
    void testTranslate4() {
        FizzBuzzTranslate fizzBuzzTranslate = new FizzBuzzTranslate();
        int number = 15;

        String expected = "FizzBuzz";
        String result =  fizzBuzzTranslate.translate(number);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test 5")
    void testTranslate5() {
        FizzBuzzTranslate fizzBuzzTranslate = new FizzBuzzTranslate();
        int number = 26;

        String expected = "Two Six";
        String result =  fizzBuzzTranslate.translate(number);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test 6")
    void testTranslate6() {
        FizzBuzzTranslate fizzBuzzTranslate = new FizzBuzzTranslate();
        int number = 0;

        String expected = "Out of range";
        String result =  fizzBuzzTranslate.translate(number);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test 7")
    void testTranslate7() {
        FizzBuzzTranslate fizzBuzzTranslate = new FizzBuzzTranslate();
        int number = 100;

        String expected = "Out of range";
        String result =  fizzBuzzTranslate.translate(number);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test 8")
    void testTranslate8() {
        FizzBuzzTranslate fizzBuzzTranslate = new FizzBuzzTranslate();
        int number = 43;

        String expected = "Fizz";
        String result =  fizzBuzzTranslate.translate(number);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test 9")
    void testTranslate9() {
        FizzBuzzTranslate fizzBuzzTranslate = new FizzBuzzTranslate();
        int number = 52;

        String expected = "Buzz";
        String result =  fizzBuzzTranslate.translate(number);
        assertEquals(expected, result);
    }
}