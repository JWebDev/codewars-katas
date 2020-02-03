import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @author JDev
 */
public class ConvertStringToCamelCase {
    private static Logger logger = Logger.getLogger("com.jdev.codewars");

    public static void main(String[] args) {
        logger.info(toCamelCase("the-stealth-warrior"));
        logger.info(toCamelCase("The_Stealth_Warrior"));
    }

    static String toCamelCase(String s) {
        final String camel = "";
        CharBuffer.wrap(s).chars().forEach(c -> {
            if (c == '-' || c == '_') camel.se += c;
        });

        return "";
    }
}
