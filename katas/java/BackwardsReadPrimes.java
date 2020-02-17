package katas.java;

import java.util.StringJoiner;
import java.util.stream.LongStream;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/5539fecef69c483c5a000015
 */
public class BackwardsReadPrimes {

    public static void main(String[] args) {
        System.out.println(backwardsPrime(2, 200));
        System.out.println(backwardsPrime(1, 31));
        System.out.println(backwardsPrime(9900, 10000));
    }

    private static String backwardsPrime(long start, long end) {
        StringJoiner backwardsPrimes = new StringJoiner(" ");
        LongStream.rangeClosed(start, end)
                .filter(prime -> isPrime(prime))
                .filter(prime -> {
                    String reversedPrime = new StringBuilder(String.valueOf(prime)).reverse().toString();
                    return prime > 10 && isPrime(Long.valueOf(reversedPrime)) && !reversedPrime.equals(String.valueOf(prime));
                }).forEach(prime -> backwardsPrimes.add(String.valueOf(prime)));
        return backwardsPrimes.toString();
    }

    private static boolean isPrime(long n) {
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
