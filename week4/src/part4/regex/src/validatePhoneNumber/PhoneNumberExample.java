package validatePhoneNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberExample {
    private Pattern pattern;
    private Matcher matcher;

    private final String PHONE_REGEX = "^\\(\\d{2}\\)-\\(0\\d+\\)";

    public PhoneNumberExample(){
        pattern = Pattern.compile(PHONE_REGEX);
    }

    public boolean validatePhone(String phoneNumber){
        matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
