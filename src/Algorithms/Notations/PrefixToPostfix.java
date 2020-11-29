package Algorithms.Notations;

import java.util.Stack;

// Again prefix so traversal will be from right to left
public class PrefixToPostfix {

    public String prefixToPostfix(String prefixString) {
        Stack<String> stack = new Stack<>();

        for(int i=prefixString.length()-1;i>=0;i--) {
            char currentChar = prefixString.charAt(i);
            if(Character.isLetterOrDigit(currentChar)) {
                stack.push(String.valueOf(currentChar));
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push(op1+op2+currentChar);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        PrefixToPostfix p = new PrefixToPostfix();
        String prefix = "*+AB-CD";
        System.out.println(prefix);
        System.out.println(p.prefixToPostfix(prefix));

        prefix = "*-A/BC-/AKL";
        System.out.println(prefix);
        System.out.println(p.prefixToPostfix(prefix));
    }
}
