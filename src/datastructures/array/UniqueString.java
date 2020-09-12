package datastructures.array;

import java.util.HashSet;
import java.util.Set;

/*
* Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
* cannot use additional data structures?
*/
public class UniqueString {

    public static void main(String[] args) {
        String s = "Ishan";

        System.out.println(containsDuplicate(s));

    }

    public static boolean containsDuplicate(String s) {
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i)))
                return false;
            else
                set.add(s.charAt(i));
        }
        return true;
    }
}
