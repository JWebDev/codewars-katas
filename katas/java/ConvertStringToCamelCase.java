package katas.java;

import java.util.regex.Pattern;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/517abf86da9663f1d2000003
 */
public class ConvertStringToCamelCase {

    public static void main(String[] args) {
        System.out.println(toCamelCase("the-stealth-warrior"));
        System.out.println(toCamelCase("The_Stealth_Warrior"));
    }

    private static String toCamelCase(String toUpper) {
        return Pattern
                .compile("[-_].")
                .matcher(toUpper)
                .replaceAll(matchResult -> String.valueOf((toUpper.charAt(matchResult.end() - 1))).toUpperCase());
    }
}
