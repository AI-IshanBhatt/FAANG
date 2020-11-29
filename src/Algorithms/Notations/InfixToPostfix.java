package Algorithms.Notations;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostfix {

    Map<Character, Integer> precedenceOrder = new HashMap<>();
    public InfixToPostfix() {
        this.precedenceOrder.put('+', 1);
        this.precedenceOrder.put('-', 1);
        this.precedenceOrder.put('*', 2);
        this.precedenceOrder.put('/', 2);
        this.precedenceOrder.put('^', 3);
    }

    public String infixToPostfix(String infixExpression) {
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<infixExpression.length();i++) {
            char currentChar = infixExpression.charAt(i);
            if(currentChar == '(') stack.push(currentChar);
            else if(currentChar == ')') {
                while (stack.peek() != '(')
                    output.append(stack.pop());
                stack.pop();
            }
//            Could have used Character.isLetterOrDigit(currentChar) instead of doing this contains
            else if(this.precedenceOrder.containsKey(currentChar)) {
                if (!stack.empty()) {
                    char top = stack.peek();
                    if (top!='(' && this.precedenceOrder.get(currentChar) <= this.precedenceOrder.get(top)) {
                        while (top!='(' && this.precedenceOrder.get(currentChar) <= this.precedenceOrder.get(top)) {
                            output.append(stack.pop());
                            if (stack.isEmpty()) break;
                            else top = stack.peek();
                        }
                    }
                }
                stack.push(currentChar);
            } else {
                output.append(currentChar);
            }
        }
        while (!stack.isEmpty()) output.append(stack.pop());
        return output.toString();
    }

    public static void main(String[] args) {
//        String infix = "a+b*c+d/e-f";
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        InfixToPostfix ipx = new InfixToPostfix();
        System.out.println(ipx.infixToPostfix(infix));
    }
}
