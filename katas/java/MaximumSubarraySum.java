package katas.java;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/54521e9ec8e60bc4de000d6c
 * <p>
 * Note: Kadane’s Algorithm
 * </p>
 */
public class MaximumSubarraySum {

    public static void main(String[] args) {
        System.out.println(sequence(new int[]{})); // => 0
        System.out.println(sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // => 6
    }

    public static int sequence(int[] arr) {
        int max_still = Integer.MIN_VALUE, max_ends = 0;
        for (int item : arr) {
            max_ends = max_ends + item;
            if (max_still < max_ends)
                max_still = max_ends;
            if (max_ends < 0)
                max_ends = 0;
        }
        return (arr.length == 0 || max_still < 0) ? 0 : max_still;
    }

}
