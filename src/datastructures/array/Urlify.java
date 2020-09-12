package datastructures.array;

/*
* Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters
* */
public class Urlify {

    public static void main(String[] args) {

        System.out.println(urlify("John Wick", 9));
    }

    public static String urlify(String s, int length) {

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<length; i++) {
            char val = s.charAt(i);
            if (val == ' ') sb.append("%20");
            else sb.append(val);
        }
        return sb.toString();
    }
}
