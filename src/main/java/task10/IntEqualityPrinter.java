package task10;

public class IntEqualityPrinter {
    public static String printEqual(int a, int b, int c) {
        if (a < 0 || b < 0 || c < 0)
            throw new IllegalArgumentException("All numbers must be non-negative");
        if (a == b && a == c)
            return "All numbers are equal";
        if (a == b || a == c || b == c)
            return "Neither all are equal or different";
        return "All numbers are different";
    }
}
