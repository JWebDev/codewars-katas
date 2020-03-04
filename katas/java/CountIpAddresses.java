package katas.java;

/**
 * @author JDev
 *
 * Kata: https://www.codewars.com/kata/526989a41034285187000de4
 */
public class CountIpAddresses {

    public static void main(String[] args) {
        System.out.println(ipsBetween("10.0.0.0", "10.0.0.50")); //50
        System.out.println(ipsBetween("20.0.0.10", "20.0.1.0")); //246
        System.out.println(ipsBetween("10.0.0.0", "10.0.1.0")); //256
    }

    public static long ipsBetween(String start, String end) {
        return -1;
    }
}
