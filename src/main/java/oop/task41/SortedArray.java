package oop.task41;

import java.util.Arrays;

public class SortedArray {
    /*public static int[] getIntegers(int size) {
        int[] arr = new int[size];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < size; i++)
            arr[i] = scanner.nextInt();
        return arr;
    }*/

    public static int[] sortIntegers(int[] arr) {
        Arrays.sort(arr);
        return reverseIntegers(arr);
    }

    public static int[] reverseIntegers(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int t = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = t;
        }
        return arr;
    }
}
