package validatePhoneNumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberExampleTest {
    @Test
    @DisplayName("Test (84)-(0978489648)")
    public void validatePhoneTest1(){
        PhoneNumberExample phoneNumberExample = new PhoneNumberExample();
        String number = "(84)-(0978489648)";
        boolean expected = true;
        boolean actual = phoneNumberExample.validatePhone(number);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test  (a8)-(22222222)")
    public void validatePhoneTest2(){
        PhoneNumberExample phoneNumberExample = new PhoneNumberExample();
        String number = "(a8)-(22222222)";
        boolean expected = false;
        boolean actual = phoneNumberExample.validatePhone(number);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test  (84)-(22b22222)")
    public void validatePhoneTest3(){
        PhoneNumberExample phoneNumberExample = new PhoneNumberExample();
        String number = "(84)-(22b22222)";
        boolean expected = false;
        boolean actual = phoneNumberExample.validatePhone(number);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test  (84)-(9978489648)")
    public void validatePhoneTest4(){
        PhoneNumberExample phoneNumberExample = new PhoneNumberExample();
        String number = "(84)-(9978489648)";
        boolean expected = false;
        boolean actual = phoneNumberExample.validatePhone(number);
        assertEquals(expected, actual);
    }

}