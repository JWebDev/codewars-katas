package katas.java;

import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/5264d2b162488dc400000001
 */
public class StopGninnipSMySdroW {
    private static Logger logger = Logger.getLogger(Class.class.getName());

    private final static List<String> sentencies = List.of("Welcome", "Hey fellow warriors", "This is a test", "This is another test");

    public static void main(String[] args) {
        sentencies.forEach(sentence -> logger.info(spinWords(sentence)));
    }

    static String spinWords(String sentence) {
        return Pattern
                .compile("(\\w{5,})")
                .matcher(sentence)
                .replaceAll(matchResult -> new StringBuilder(matchResult.group(0)).reverse().toString());
    }
}
