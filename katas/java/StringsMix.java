package katas.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isLowerCase;
import static java.util.stream.Collectors.toList;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/5629db57620258aa9d000014
 */
public class StringsMix {

    public static void main(String[] args) {
//        System.out.println(mix("Are they here", "yes, they are here")); //2:eeeee/2:yy/=:hh/=:rr
        System.out.println(mix("looping is fun but dangerous", "less dangerous than coding")); //1:ooo/1:uuu/2:sss/=:nnn/1:ii/2:aa/2:dd/2:ee/=:gg
//
    }

    public static String mix(String s1, String s2) {
        Map<String, Integer> map1 = new HashMap<>(), map2 = new HashMap<>(), mergeMap = new HashMap<>();
        List<String> unique = new ArrayList<>();
        StringJoiner joiner = new StringJoiner("/");

        s1.chars().filter(w -> isAlphabetic(w) && isLowerCase(w)).forEach(w -> map1.put(Character.toString(w), map1.getOrDefault(Character.toString(w), 0) + 1));
        s2.chars().filter(w -> isAlphabetic(w) && isLowerCase(w)).forEach(w -> map2.put(Character.toString(w), map2.getOrDefault(Character.toString(w), 0) + 1));
        mergeMap = Stream.of(map1, map2).flatMap(m -> m.entrySet().stream()).filter(entry -> entry.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Math::max));
        mergeMap.forEach((k, v) -> {
            unique.add(map1.containsKey(k) && map2.containsKey(k)
                    ? map1.get(k).equals(map2.get(k)) ? "" : v.equals(map1.get(k)) ? "1:" + k.repeat(v) : "2:" + k.repeat(v)
                    : map1.containsKey(k) ? "1:" + k.repeat(v) : "2:" + k.repeat(v));
            unique.add((map1.containsKey(k) && map2.containsKey(k) && map1.get(k).equals(map2.get(k))) ? "=:" + k.repeat(v) : "");
        });
        Map<Integer, List<String>> groupedMap = unique.stream().filter(str -> !str.isEmpty()).collect(Collectors.groupingBy(str -> (int) str.chars().filter(ch -> isAlphabetic(ch)).count())); //collect(Collectors.joining());
        groupedMap.keySet().stream().sorted(Comparator.reverseOrder()).collect(toList()).forEach(i -> {
            groupedMap.get(i).stream().sorted().forEach(str -> joiner.add(str));
        });

        return joiner.toString();
    }

}
