package task6;

public class EqualSumChecker {
    public static boolean hasEqualSum(int a, int b, int c) {
        long sum = (long)a+(long)b;
        if(sum>Integer.MAX_VALUE || sum<Integer.MIN_VALUE)
            return false;

        System.out.println(Integer.MAX_VALUE+1);
        return sum == c;
    }
}
