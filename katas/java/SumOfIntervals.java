package katas.java;

import java.util.stream.IntStream;

/**
 * @author JDev
 *
 * Kata: https://www.codewars.com/kata/52b7ed099cdc285c300001cd
 */
public class SumOfIntervals {

    public static void main(String[] args) {
        System.out.println(multiplies(10));
    }

    private static int multiplies(int number) {
        return IntStream.range(0, number).filter(n -> (n % 3 == 0 || n % 5 == 0)).sum();
    }
}
