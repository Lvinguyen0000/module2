package utility;

import java.security.SecureRandom;

public class StringGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom secureRandom = new SecureRandom();

    private static StringGenerator stringGenerator = null;

    private StringGenerator(){}

    public static StringGenerator getInstance(){
        if (stringGenerator == null){
            stringGenerator = new StringGenerator();
        }
        return stringGenerator;
    }

    public static String generateRandomString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            result.append(CHARACTERS.charAt(secureRandom.nextInt(CHARACTERS.length())));
            // Add a hyphen after every 4 characters except the last group
            if (i % 4 == 3 && i < 19) {
                result.append("-");
            }
        }
        return result.toString();
    }
}
