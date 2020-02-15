package katas.java;

import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 * @author JDev
 *
 * Kata: https://www.codewars.com/kata/514b92a657cdc65150000006
 */
public class MultiplesOf3or5 {
    private static Logger logger = Logger.getLogger("com.jdev.codewars");

    public static void main(String[] args) {
        int multilplies = multiplies(10);
        logger.info(String.valueOf(multilplies));
    }

    public static int multiplies(int number) {
        return IntStream.range(0, number).filter(n -> (n % 3 == 0 || n % 5 == 0)).sum();
    }
}