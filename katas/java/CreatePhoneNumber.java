package katas.java;

import java.util.Arrays;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/525f50e3b73515a6db000b83
 */
public class CreatePhoneNumber {

    public static void main(String[] args) {
        System.out.println(createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }

    private static String createPhoneNumber(int[] numbers) {
        StringBuilder sb = new StringBuilder(Arrays.toString(numbers).replaceAll("\\[|\\]|,|\\s", ""));
        return sb.insert(0, "(").insert(4, ") ").insert(9, "-").toString();
    }
}
