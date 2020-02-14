package katas.java;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @author JDev
 *
 * Kata: https://www.codewars.com/kata/525f50e3b73515a6db000b83
 */
public class CreatePhoneNumber {
    private static Logger logger = Logger.getLogger("com.jdev.codewars");

    public static void main(String[] args) {
        String phoneNumber = createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        logger.info(phoneNumber);
    }

    public static String createPhoneNumber(int[] numbers) {
        StringBuilder sb = new StringBuilder(Arrays.toString(numbers).replaceAll("\\[|\\]|,|\\s", ""));
        return sb.insert(0, "(").insert(4, ") ").insert(9, "-").toString();
    }
}
