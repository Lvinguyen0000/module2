package utility.validation;

import java.util.regex.Pattern;

public class PhoneNumberValidation extends Validation {
    private static PhoneNumberValidation phoneNumberValidation = null;

    private PhoneNumberValidation(){}

    public static PhoneNumberValidation getInstance(){
        if (phoneNumberValidation == null){
            phoneNumberValidation = new PhoneNumberValidation();
        }
        return phoneNumberValidation;
    }

    public boolean validate(String phoneNumber) {
        Pattern pattern = Pattern.compile("^0\\d{9}$");
        return pattern.matcher(phoneNumber).matches();
    }
}
