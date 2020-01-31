import java.util.List;
import java.util.logging.Logger;

/**
 * @author JDev
 */
public class DecodeTheMorseCode {
    private static Logger logger = Logger.getLogger("com.jdev.codewars");

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
        logger.info(decoded);
    }

    public static String decode(String morseCode) {
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
