package katas.java;

import java.util.List;

/**
 * @author JDev
 *
 * Kata: https://www.codewars.com/kata/54b724efac3d5402db00065e
 */
public class DecodeTheMorseCode {

    private static List<Character> english = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
            ',', '.', '?');

    private static List<String> morse = List.of(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "--..--", ".-.-.-", "..--..");

    public static void main(String[] args) {
        String decoded = decode(".... . -.--   .--- ..- -.. ."); //HEY JUDE
        System.out.println(decoded);
    }

    private static String decode(String morseCode) {
        String decodedMorse = "";
        String[] letters = morseCode.trim().replaceAll("\\s{3}", " SPACE ").split("\\s");
        for (String letter : letters) {
            String decodedLetter = letter.equals("SPACE")
                    ? " "
                    : english.get(morse.indexOf(letter)).toString();
            decodedMorse += decodedLetter.toUpperCase();
        }
        return decodedMorse;
    }
}
