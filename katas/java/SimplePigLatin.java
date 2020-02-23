package katas.java;

import java.util.regex.Pattern;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/517abf86da9663f1d2000003
 */
public class SimplePigLatin {

    public static void main(String[] args) {
        System.out.println(pigIt("Pig latin is cool"));  // => igPay atinlay siay oolcay
        System.out.println(pigIt("This is my string"));  // => hisTay siay ymay tringsay
    }

    public static String pigIt(String str) {
        return Pattern
                .compile("[-_].")
                .matcher(str)
                .replaceAll(matchResult -> String.valueOf((toUpper.charAt(matchResult.end() - 1))).toUpperCase());
    }

    private static String toCamelCase(String toUpper) {
        return Pattern
                .compile("[-_].")
                .matcher(toUpper)
                .replaceAll(matchResult -> String.valueOf((toUpper.charAt(matchResult.end() - 1))).toUpperCase());
    }
}
