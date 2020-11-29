package Algorithms.Notations;

import java.util.HashSet;
import java.util.Stack;
import java.util.Set;

// If you are doing stuff from prefix, You need to traverse backwards, from the right side
// PREFIX *+AB-CD INFIX (A+B) * (C-D)
public class PrefixToInfix {


    public String prefixToInfix(String prefixString) {
        Stack<String> stack = new Stack<>();

        for(int i=prefixString.length()-1; i>=0; i--) {
            char currentChar = prefixString.charAt(i);
            if(Character.isLetterOrDigit(currentChar)) {
                stack.push(String.valueOf(currentChar));
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push("("+op1+currentChar+op2+")");
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        PrefixToInfix prefixToInfix = new PrefixToInfix();
        String prefixString = "*-A/BC-/AKL";
        System.out.println(prefixString);
        System.out.println(prefixToInfix.prefixToInfix(prefixString));
    }
}
