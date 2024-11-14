package part3.apj_2023_calculator.src;

public class Calculator {
    public static final char ADDITION = '+';
    public static final char SUBTRACTION = '-';
    public static final char MULTIPLICATION = '*';
    public static final char DIVISION = '/';

    public static int calculate(int a, int secondOperand, char operator) {
        switch (operator) {
            case ADDITION:
                return a + secondOperand;
            case SUBTRACTION:
                return a - secondOperand;
            case MULTIPLICATION:
                return a * secondOperand;
            case DIVISION:
                if (secondOperand != 0)
                    return a / secondOperand;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }
}
