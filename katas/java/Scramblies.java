package katas.java;

import java.util.List;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/55c04b4cc56a697bb0000048
 */
public class Scramblies {

    public static void main(String[] args) {
        System.out.println(scramble("rkqodlw","world")); //true
        System.out.println(scramble("cedewaraaossoqqyt","codewars")); //true
        System.out.println(scramble("katas","steak")); //false
        System.out.println(scramble("scriptjavx", "javascript")); //false
        System.out.println(scramble("scriptingjava","javascript")); //true
        System.out.println(scramble("scriptsjava","javascripts")); //true
        System.out.println(scramble("javscripts","javascript")); //false
        System.out.println(scramble("aabbcamaomsccdd","commas")); //true
        System.out.println(scramble("commas","commas")); //true
        System.out.println(scramble("sammoc","commas")); //true
    }

    public static boolean scramble(String str1, String str2) {
        for (String l : List.of(str2.split(""))) {
            if (str1.contains(l)) {
                str1=str1.replaceFirst(l, "");
            } else {
                return false;
            }
        }
        return true;
    }
}
