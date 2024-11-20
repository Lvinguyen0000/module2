package validateEmail;

import part4.regex.src.validateEmail.EmailExample;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class EmailExampleTest {

    @Test
    @DisplayName("Test a@gmail.com")
    void validateEmail1() {
        EmailExample emailExample = new EmailExample();
        String email = "a@gmail.com";
        boolean expected = true;
        boolean actual = emailExample.validateEmail(email);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test ab@yahoo.com")
    void validateEmail2() {
        EmailExample emailExample = new EmailExample();
        String email = "ab@yahoo.com";
        boolean expected = true;
        boolean actual = emailExample.validateEmail(email);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test abc@hotmail.com")
    void validateEmail3() {
        EmailExample emailExample = new EmailExample();
        String email = "abc@hotmail.com";
        boolean expected = true;
        boolean actual = emailExample.validateEmail(email);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test @gmail.com")
    void validateEmail4() {
        EmailExample emailExample = new EmailExample();
        String email = "@gmail.com";
        boolean expected = false;
        boolean actual = emailExample.validateEmail(email);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test ab@gmail.")
    void validateEmail5() {
        EmailExample emailExample = new EmailExample();
        String email = "ab@gmail.";
        boolean expected = false;
        boolean actual = emailExample.validateEmail(email);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test @#abc@gmail.com")
    void validateEmail6() {
        EmailExample emailExample = new EmailExample();
        String email = "@#abc@gmail.com";
        boolean expected = false;
        boolean actual = emailExample.validateEmail(email);
        assertEquals(expected, actual);
    }
}