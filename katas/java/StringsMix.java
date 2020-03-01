package katas.java;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/5629db57620258aa9d000014
 */
public class StringsMix {

    private static Map<String, Integer> mapOne = new HashMap<>();
    private static Map<String, Integer> mapTwo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(mix("Are they here", "yes, they are here"));
    }

    public static String mix(String s1, String s2) {
        s1.chars().filter(w -> Character.isAlphabetic(w) && Character.isLowerCase(w)).forEach(w -> mapOne.put(Character.toString(w), mapOne.getOrDefault(Character.toString(w), 0) + 1));
        s2.chars().filter(w -> Character.isAlphabetic(w) && Character.isLowerCase(w)).forEach(w -> mapTwo.put(Character.toString(w), mapTwo.getOrDefault(Character.toString(w), 0) + 1));
        Map<String, Integer> mapFour = new HashMap<>();
        Map<String, Integer> mapThree = Stream.of(mapOne, mapTwo).flatMap(m -> m.entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey,))
//                        (Collectors. toMap(Map.Entry::getKey, Map.Entry::getValue, (existing, replacement) -> {
//                    int iii = Math.max(existing, replacement);
//                    return existing;
//                }));
        mapThree = sortMapByValue(mapThree);
        mapTwo = sortMapByValue(mapTwo);
        return null;
    }

    private static Map<String, Integer> sortMapByValue(Map<String, Integer> map) {
        return map.entrySet().stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
    }
}
