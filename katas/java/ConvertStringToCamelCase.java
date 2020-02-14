package katas.java;

import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/517abf86da9663f1d2000003
 */
public class ConvertStringToCamelCase {
    private static Logger logger = Logger.getLogger(Class.class.getName());

    public static void main(String[] args) {
        logger.info(toCamelCase("the-stealth-warrior"));
        logger.info(toCamelCase("The_Stealth_Warrior"));
    }

    static String toCamelCase(String toUpper) {
        return Pattern
                .compile("[-_].")
                .matcher(toUpper)
                .replaceAll(matchResult -> String.valueOf((toUpper.charAt(matchResult.end() - 1))).toUpperCase());
    }
}
