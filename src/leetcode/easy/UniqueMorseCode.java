package leetcode.easy;

import java.util.Set;
import java.util.HashSet;

// https://leetcode.com/problems/unique-morse-code-words/
public class UniqueMorseCode {

    public static void main(String[] args) {
        String[] words = new String[]{"gin", "zen", "gig", "msg"};
        int answer =uniqueMorseRepresentations(words);
        System.out.println(answer);
    }

//    Our main motive to solve this simplistic problem is to familiarize with Character and their ascii values
    public static int uniqueMorseRepresentations(String[] words) {
        String[] morseCodes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
                "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> uniqueWords = new HashSet<>();
        int base = 97, counter=0;
        String currentString = "";
        StringBuilder sb = new StringBuilder();
        for(String word: words) {
            for(int i=0;i<word.length();i++)
                sb.append(morseCodes[word.codePointAt(i)-base]);
            currentString = sb.toString();
            if(!uniqueWords.contains(currentString)) {
                uniqueWords.add(currentString);
                counter++;
            }
            sb.setLength(0);
        }

        return counter;
    }
}
