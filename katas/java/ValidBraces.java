package katas.java;

import java.util.Map;
import java.util.Stack;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/5539fecef69c483c5a000015
 */
public class ValidBraces {

    public static void main(String[] args) {
        System.out.println(isValid("( ) {}[]")); // => True
        System.out.println(isValid("([{}])")); // => True
        System.out.println(isValid("(}")); // => False
        System.out.println(isValid("[(])")); // => False
        System.out.println(isValid("[({})](]")); // => False
        System.out.println(isValid("((({")); // => False
    }

    private static boolean isValid(String braces) {
        Stack<Character> bStack = new Stack<Character>();
        Map<Character, Character> pairs = Map.of('[', ']', '{', '}', '(', ')');
        for (char c : braces.replaceAll("\\s", "").toCharArray()) {
            if (String.valueOf(c).matches("[\\[\\{\\(]")) {
                bStack.push(c);
            } else if (bStack.isEmpty() || pairs.get(bStack.pop()) != c) {
                return false;
            }
        }
        return bStack.isEmpty();
    }

}
