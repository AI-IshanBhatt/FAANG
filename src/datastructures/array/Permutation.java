package datastructures.array;

import java.util.Arrays;
/* Given two strings, write a method to decide if one is a permutation of the
other.
 */
public class Permutation {

    public static void main(String[] args) {

        System.out.println(isPermutation("LALA", "AAaLL"));
    }

    public static boolean isPermutation(String s1, String s2) {
        char[] content1 = s1.toCharArray();
        char[] content2 = s2.toCharArray();

        Arrays.sort(content1);
        Arrays.sort(content2);

        return new String(content1).equals(new String(content2));
    }
}
