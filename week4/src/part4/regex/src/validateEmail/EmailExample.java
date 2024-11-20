package part4.regex.src.validateEmail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExample {
    private Pattern pattern;
    private Matcher matcher;

    private final String EMAIL_REGEX = "^\\w+\\w*@\\w+(\\.\\w+)$";

    public EmailExample() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
