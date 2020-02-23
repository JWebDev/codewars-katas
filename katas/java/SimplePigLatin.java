package katas.java;

import java.util.regex.Pattern;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/520b9d2ad5c005041100000f
 */
public class SimplePigLatin {

    public static void main(String[] args) {
        System.out.println(pigIt("Pig latin is cool"));  // => igPay atinlay siay oolcay
        System.out.println(pigIt("This is my string"));  // => hisTay siay ymay tringsay
    }

    public static String pigIt(String str) {
        return Pattern.compile("\\b\\w+\\b")
                .matcher(str)
                .replaceAll(mR -> mR.group(0).substring(1) + mR.group(0).charAt(0) + "ay");
    }
}
