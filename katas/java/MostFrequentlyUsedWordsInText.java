package katas.java;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/51e056fe544cf36c410000fb
 */
public class MostFrequentlyUsedWordsInText {

    public static void main(String[] args) {
        System.out.println(top3("\"In a village of La Mancha, the name of which I have no desire to call to\n" +
                "mind, there lived not long since one of those gentlemen that keep a lance\n" +
                "in the lance-rack, an old buckler, a lean hack, and a greyhound for\n" +
                "coursing. An olla of rather more beef than mutton, a salad on most\n" +
                "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra\n" +
                "on Sundays, made away with three-quarters of his income.\""));  // => ["a", "of", "on"]
        System.out.println(top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"));  // => ["e", "ddd", "aa"]
        System.out.println(top3("  //wont won't won't"));  // => ["won't", "wont"]
    }

    public static List<String> top3(String s) {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        Matcher matcher = Pattern.compile("[a-z][a-z']*").matcher(s.toLowerCase());
        while (matcher.find()) {
            String key = matcher.group(0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        Map<String, Integer> sortedMap = map.entrySet().stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

        return sortedMap.keySet().size() > 3 ? sortedMap.keySet().stream().collect(Collectors.toList()).subList(0, 3) : sortedMap.keySet().stream().collect(Collectors.toList());
    }

}
