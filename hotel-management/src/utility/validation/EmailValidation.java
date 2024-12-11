package utility.validation;

import java.util.regex.Pattern;

public class EmailValidation extends Validation {
    private static EmailValidation emailValidation = null;

    private EmailValidation(){}

    public static EmailValidation getInstance(){
        if (emailValidation == null){
            emailValidation = new EmailValidation();
        }
        return emailValidation;
    }

    public boolean validate(String email) {
        Pattern pattern = Pattern.compile("^\\w+\\w*@\\w+(\\.\\w+)$");
        return pattern.matcher(email).matches();
    }
}
