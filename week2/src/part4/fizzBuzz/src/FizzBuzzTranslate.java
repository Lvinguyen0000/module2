public class FizzBuzzTranslate {
    public String translate(int n) {
        if (n < 1 || n > 99) return "Out of range";

        if (n % 3 == 0 && n % 5 == 0) return "FizzBuzz";
        else if (n % 3 == 0) return "Fizz";
        else if (n % 5 == 0) return "Buzz";
        String strNum = String.valueOf(n);
        if (checkThree(strNum)) return "Fizz";
        else if (checkFive(strNum)) return "Buzz";

        return converString(strNum);
    }

    private boolean checkThree(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '3') return true;
        }
        return false;
    }

    private boolean checkFive(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '5') return true;
        }
        return false;
    }

    private String convertChar(char c){
        return switch (c) {
            case '1' -> "One";
            case '2' -> "Two";
            case '3' -> "Three";
            case '4' -> "Four";
            case '5' -> "Five";
            case '6' -> "Six";
            case '7' -> "Seven";
            case '8' -> "Eight";
            case '9' -> "Nine";
            default -> "";
        };
    }

    private String converString(String str){
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            temp.append(convertChar(str.charAt(i)));
            temp.append(" ");
        }
        temp.setLength(temp.length()-1);
        return temp.toString();
    }
}
