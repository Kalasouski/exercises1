package oop.task42;

public class MinimumElement {
    public static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int a : arr)
            if (a < min)
                min = a;
        return min;
    }
}
