package cursor.rybak.util;

public class Validation {
    private static Validation instance;

    private Validation() {}

    public static Validation getInstance() {
        if (instance == null) {
            instance = new Validation();
        }

        return instance;
    }

    public boolean isNumberInput(String input) {
        return input.matches("\\d+");
    }

    public boolean isMatchOptions(String input, String options) {
        return input.matches("[" + options + "]");
    }

    public boolean isNumberInRange(int input, int minValue, int maxValue) {
        return (input > minValue) && (input <= maxValue);
    }
}
