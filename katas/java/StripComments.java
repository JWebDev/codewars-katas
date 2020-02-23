package katas.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/51c8e37cee245da6b40000bd
 */
public class StripComments {

    public static void main(String[] args) {
        System.out.println(stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[]{"#", "!"}));  // => apples, pears\ngrapes\nbananas
        System.out.println(stripComments("a #b\nc\nd $e f g", new String[]{"#", "$"}));  // => a\nc\nd
        System.out.printf(stripComments("a \n b \nc", new String[]{"#", "$"}));  // => a\n b\nc
    }

    public static String stripComments(String text, String[] commentSymbols) {
        String symbols = String.join("|", commentSymbols);
        return Stream.of(text.split("\n"))
                .map(elem -> {
                    Matcher mR = Pattern.compile("[" + symbols + "]").matcher(elem);
                    return mR.find() ? elem.substring(0, mR.start()).stripTrailing() : elem.stripTrailing();
                }).collect(Collectors.joining("\n"));
    }
}
