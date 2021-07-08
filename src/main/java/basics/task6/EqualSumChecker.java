package basics.task6;

public class EqualSumChecker {
    public static boolean hasEqualSum(int a, int b, int c) {
        long sum = (long) a + (long) b;
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE)
            return false;
        return sum == c;
    }
}
