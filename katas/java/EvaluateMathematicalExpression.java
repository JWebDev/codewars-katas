package katas.java;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/517abf86da9663f1d2000003
 */
public class EvaluateMathematicalExpression {

    public static void main(String[] args) throws ScriptException {
        System.out.println("Result = " + calculate("1+1"));
    }

    private static double calculate(String expression) throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
        Object ob = scriptEngine.eval(expression);

        return ((Integer) ob).doubleValue();
    }

}
