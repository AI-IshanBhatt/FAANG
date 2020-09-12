package datastructures.array;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import static java.util.stream.Collectors.*;

/*
One Away: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
 */
public class OneAway {

    public static void main(String[] args) {
        System.out.println(isOneAway("pale", "ple"));
        System.out.println(isOneAway("pales", "pale"));
        System.out.println(isOneAway("pale", "bale"));
        System.out.println(isOneAway("pale", "bake"));
    }

    public static boolean isOneAway(String s1, String s2) {
        Function<String, Map<Character, Long>> stringFreq =
                s -> s.chars().mapToObj(c -> (char) c).collect(groupingBy(Function.identity(), counting()));

        Map<Character, Long> f1 = stringFreq.apply(s1);
        Map<Character, Long> f2 = stringFreq.apply(s2);

        int offCount = 0;
        for (Map.Entry<Character, Long> e: f1.entrySet()) {
            long freq1 = e.getValue();
            if (freq1 != f2.getOrDefault(e.getKey(), 0L)) offCount++;
            if(offCount > 1) return false;
        }
        return true;
    }
}
