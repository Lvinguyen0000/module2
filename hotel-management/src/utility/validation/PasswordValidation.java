package utility.validation;

import java.util.regex.Pattern;

public class PasswordValidation extends Validation {
    private static PasswordValidation passwordValidation = null;
    private PasswordValidation(){}

    public static PasswordValidation getInstance(){
        if (passwordValidation == null){
            passwordValidation = new PasswordValidation();
        }
        return passwordValidation;
    }
    public boolean validate(String password) {
        Pattern pattern = Pattern.compile("^[_a-z0-9]{6,}$");
        return pattern.matcher(password).matches();
    }
}
