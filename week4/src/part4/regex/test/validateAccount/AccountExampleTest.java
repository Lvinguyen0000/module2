package validateAccount;

import part4.regex.src.validateAccount.AccountExample;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountExampleTest {

    @Test
    @DisplayName("Test 123abc_")
    void validateAccount1() {
        AccountExample accountExample = new AccountExample();
        String account = "123abc_";
        boolean expected = true;
        boolean actual = accountExample.validateAccount(account);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test _abc123")
    void validateAccount2() {
        AccountExample accountExample = new AccountExample();
        String account = "_abc123";
        boolean expected = true;
        boolean actual = accountExample.validateAccount(account);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test ______")
    void validateAccount3() {
        AccountExample accountExample = new AccountExample();
        String account = "______";
        boolean expected = true;
        boolean actual = accountExample.validateAccount(account);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test 123456")
    void validateAccount4() {
        AccountExample accountExample = new AccountExample();
        String account = "123456";
        boolean expected = true;
        boolean actual = accountExample.validateAccount(account);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test abcdefg")
    void validateAccount5() {
        AccountExample accountExample = new AccountExample();
        String account = "abcdefg";
        boolean expected = true;
        boolean actual = accountExample.validateAccount(account);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test .@")
    void validateAccount6() {
        AccountExample accountExample = new AccountExample();
        String account = ".@";
        boolean expected = false;
        boolean actual = accountExample.validateAccount(account);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test 12345")
    void validateAccount7() {
        AccountExample accountExample = new AccountExample();
        String account = "12345";
        boolean expected = false;
        boolean actual = accountExample.validateAccount(account);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test 1234_")
    void validateAccount8() {
        AccountExample accountExample = new AccountExample();
        String account = "1234_";
        boolean expected = false;
        boolean actual = accountExample.validateAccount(account);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test abcde")
    void validateAccount9() {
        AccountExample accountExample = new AccountExample();
        String account = "abcde";
        boolean expected = false;
        boolean actual = accountExample.validateAccount(account);
        Assertions.assertEquals(expected, actual);
    }
}
