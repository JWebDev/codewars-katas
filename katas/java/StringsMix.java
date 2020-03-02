package katas.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isLowerCase;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/5629db57620258aa9d000014
 */
public class StringsMix {

    public static void main(String[] args) {
        System.out.println(mix("Are they here", "yes, they are here")); //2:eeeee/2:yy/=:hh/=:rr
        System.out.println(mix("looping is fun but dangerous", "less dangerous than coding")); //1:ooo/2:sss/1:uuu/2:aa/2:dd/2:ee/1:ii/=:nnn/=:gg
//        1:ooo/1:uuu/2:sss/=:nnn/1:ii/2:aa/2:dd/2:ee/=:gg
    }

    public static String mix(String s1, String s2) {
        Map<String, Integer> map1 = new HashMap<>(), map2 = new HashMap<>(), mergeMap = new HashMap<>();
        List<String> unique = new ArrayList<>(), pairs = new ArrayList<>();
        s1.chars().filter(w -> isAlphabetic(w) && isLowerCase(w)).forEach(w -> map1.put(Character.toString(w), map1.getOrDefault(Character.toString(w), 0) + 1));
        s2.chars().filter(w -> isAlphabetic(w) && isLowerCase(w)).forEach(w -> map2.put(Character.toString(w), map2.getOrDefault(Character.toString(w), 0) + 1));
        mergeMap = Stream.of(map1, map2).flatMap(m -> m.entrySet().stream()).filter(entry -> entry.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Math::max));
//        mergeMap = sortMapByValue(mergeMap);
        mergeMap.forEach((k, v) -> {
            unique.add(map1.containsKey(k) && map2.containsKey(k)
                    ? map1.get(k).equals(map2.get(k)) ? "" : v.equals(map1.get(k)) ? k.repeat(v) + "/1:" : k.repeat(v) + "/2:"
                    : map1.containsKey(k) ? k.repeat(v) + "/1:" : k.repeat(v) + "/2:");
            unique.add((map1.containsKey(k) && map2.containsKey(k) && map1.get(k).equals(map2.get(k))) ? k.repeat(v) + "/=:" : "");
        });
        unique.sort(Comparator.comparing(String::length, Comparator.reverseOrder()).thenComparing(String::compareTo));
        String collectedMax = unique.stream().filter(str -> !str.isEmpty())
                .map(str -> str.substring(str.indexOf("/"), str.length()) + str.substring(0, str.indexOf("/"))).collect(Collectors.joining());
//        String collectedPairs = pairs.stream().filter(str -> !str.isEmpty())
//                .map(str -> str.substring(str.indexOf("/"), str.length()) + str.substring(0, str.indexOf("/"))).collect(Collectors.joining());
        return collectedMax.substring(0, collectedMax.length() - 1);
    }

}
