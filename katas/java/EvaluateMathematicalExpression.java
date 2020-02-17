package katas.java;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/517abf86da9663f1d2000003
 */
public class EvaluateMathematicalExpression {

    public static void main(String[] args) {
        System.out.printf("%-30s %-10.4f\n", "3 - -( -3) = ", calculate("3 - -( -3)")); //0
//        System.out.printf("%-30s %-10.4f\n", "1 - -(-(-(-4))) = ", calculate("1 - -(-(-(-4)))")); //0
//        System.out.printf("%-30s %-10.4f\n", "((80 - (19))) = ", calculate("((80 - (19)))")); //61
//        System.out.printf("%-30s %-10.4f\n", "3 - -3 = ", calculate("3 - -3")); //6
//        System.out.printf("%-30s %-10.4f\n", "-123 = ", calculate("-123"));
//        System.out.printf("%-30s %-10.4f\n", "2 /2+3 * 4.75- -6 = ", calculate("2 /2+3 * 4.75- -6")); //21.25
//        System.out.printf("%-30s %-10.4f\n", "2 / (2 + 3) * 4.33 - -6 = ", calculate("2 / (2 + 3) * 4.33 - -6")); //7.732
//        System.out.printf("%-30s %-10.4f\n", "12* 123 = ", calculate("12* 123")); //1476
//        System.out.printf("%-30s %-10.4f\n", "3 + 4 * 2 / ( 1 - ((55)) ) = ", calculate("3 + 4 * 2 / ( 1 - ((55)) )")); //8.851
//        System.out.printf("%-30s %-10.4f\n", "1-1 = ", calculate("1-1")); //0
//        System.out.printf("%-30s %-10.4f\n", "1 - -1 = ", calculate("1 - -1")); //2
    }

    private static double calculate(String expression) {
        Stack<Double> vStack = new Stack<Double>();
        Stack<Character> oStack = new Stack<Character>();
        List<Character> chars = expression.replaceAll("\\s", "").chars().mapToObj(c -> Character.valueOf((char) c)).collect(Collectors.toList());
        for (int i = 0; i < chars.size(); i++) {
//            if (chars.get(i) == ' ')
//                continue;

            if (isDigit(chars, i) || isNegativeNumber(chars, i)) {
                String buffer = "";
                while (i < chars.size() && (isDigit(chars, i) || isNegativeNumber(chars, i)))
                    buffer += chars.get(i++);
                vStack.push(Double.valueOf(buffer));
                i--;
            } else if (chars.get(i) == '(') {
                oStack.push(chars.get(i));
            } else if (chars.get(i) == ')') {
                while (oStack.peek() != '(')
                    vStack.push(applyOperation(oStack.pop(), vStack.pop(), vStack.pop()));
                oStack.pop();
            } else if (chars.get(i).toString().matches("[\\+\\-\\*\\/]")) {
//                if (!isNegativeNumber(chars, i)) {
                    while (!oStack.empty() && hasPrecedence(chars.get(i), oStack.peek()))
                        vStack.push(applyOperation(oStack.pop(), vStack.pop(), vStack.pop()));
                    oStack.push(chars.get(i));
//                }
            }
        }
        while (!oStack.empty())
            vStack.push(applyOperation(oStack.pop(), vStack.pop(), vStack.pop()));

        return vStack.pop().doubleValue();
    }

    private static boolean isDigit(List<Character> chars, int index) {
        return Character.isDigit(chars.get(index)) || chars.get(index) == '.';
    }

    private static boolean isNegativeNumber(List<Character> chars, int index) {
        if (index == 0 && chars.get(index) == '-') {
            return true;
        } else if (!Character.isDigit(chars.get(index - 1)) && chars.get(index) == '-' && Character.isDigit(chars.get(index + 1))) {
            return true;
//        } else if (chars.get(index) == '-' && Character.isDigit(chars.get(index + 1))) {
//            return true;
        } else if (chars.get(index) == '-' && chars.get(index + 1) == '-' && index < chars.size() && Character.isDigit(chars.get(index + 2))) {
            return false;
        }
        return false;
//        return (index == 0 || chars.get(index - 1) == ' ') && chars.get(index) == '-' && Character.isDigit(chars.get(index + 1));
    }

    private static boolean hasPrecedence(char lOp, char rOp) {
        if (rOp == '(' || rOp == ')')
            return false;
        if ((lOp == '*' || lOp == '/') && (rOp == '+' || rOp == '-'))
            return false;
        else
            return true;
    }

    private static double applyOperation(Character o, double r, double l) {
        switch (o) {
            case '-':
                return l - r;
            case '+':
                return l + r;
            case '*':
                return l * r;
            case '/':
                return l / r;
        }
        return 0;
    }

}
