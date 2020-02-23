package katas.java;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/5264d2b162488dc400000001
 */
public class ThereWasAnOldLadyWhoSwallowedFly {

    private static String sentencies = "There was an old lady who swallowed a fly; \n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a spider;\n" +
            "That wriggled and jiggled and tickled inside her!\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - Perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a bird;\n" +
            "How absurd to swallow a bird!\n" +
            "She swallowed the bird to catch the spider;\n" +
            "That wriggled and jiggled and tickled inside her!\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - Perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a cat;\n" +
            "Fancy that she swallowed a cat!\n" +
            "She swallowed the cat to catch the bird,\n" +
            "She swallowed the bird to catch the spider;\n" +
            "That wriggled and jiggled and tickled inside her!\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - Perhaps she'll die!";

    public static void main(String[] args) {
        System.out.println(oldLadySwallows(Arrays.asList("fly", "spider")));
        System.out.println(oldLadySwallows(Arrays.asList("fly", "spider", "bird")));
        System.out.println(oldLadySwallows(Arrays.asList("bird", "fly", "spider")));
        System.out.println(oldLadySwallows(Arrays.asList("fly")));
    }

    public static List<String> oldLadySwallows(final List<String> animals) {
        List<String> lines = Arrays.asList(sentencies.split("\n"));
        animals.forEach(animal -> {
            Matcher matcher = Pattern
                    .compile("(There was an old lady (who|that) swallowed a )(cat|cow|goat|dog|bird|spider|fly|horse)")
                    .matcher(animal);
        });
        return animals;
    }
}
