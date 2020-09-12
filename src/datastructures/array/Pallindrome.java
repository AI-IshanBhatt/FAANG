package datastructures.array;

import java.util.HashMap;
import java.util.Map;

/* Given a string, write a function to check if it is a permutation of a palindrome.
A palindrome is a word or phrase that is the same forwards and backwards. A permutation
is a rearrangement of letters.
 */

public class Pallindrome {

    public static void main(String[] args) {
        System.out.println(isPallindromePerutation("tact coa"));
    }

    public static boolean isPallindromePerutation(String s) {
        Map<Character, Integer> m = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char current = s.charAt(i);
            if (current == ' ') continue;
            int count = m.getOrDefault(current, 0);
            m.put(current, ++count);
        }

        long count = m.values().stream().filter(integer -> integer % 2 == 1).count();
        if (count > 1) return false;
        else return true;
    }
}
