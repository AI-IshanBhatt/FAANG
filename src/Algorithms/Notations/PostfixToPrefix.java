package Algorithms.Notations;

import java.util.Stack;

public class PostfixToPrefix {

    public String postfixToPrefix(String postfix) {
        Stack<String> stack = new Stack<>();

        for(int i=0;i<postfix.length();i++) {
            char currentChar = postfix.charAt(i);
            if(Character.isLetterOrDigit(currentChar)) {
                stack.push(String.valueOf(currentChar));
            } else {
                String op2 = stack.pop();
                String op1 = stack.pop();
                stack.push(currentChar+op1+op2);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        PostfixToPrefix p = new PostfixToPrefix();
        String postfix = "AB+CD-*";
        System.out.println(postfix);
        System.out.println(p.postfixToPrefix(postfix));

        postfix = "ABC/-AK/L-*";
        System.out.println(postfix);
        System.out.println(p.postfixToPrefix(postfix));
    }
}
