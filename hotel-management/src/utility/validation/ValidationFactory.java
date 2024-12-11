package utility.validation;

public class ValidationFactory {
    public ValidationFactory() {}
    public Validation getValidation(String type){
        return switch (type) {
            case "email" -> EmailValidation.getInstance();
            case "password" -> PasswordValidation.getInstance();
            case "phone" -> PhoneNumberValidation.getInstance();
            case "dob" -> DateValidation.getInstance();
            default -> null;
        };
    }
}
