package datastructures.array;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Stack;

// https://www.geeksforgeeks.org/next-greater-element/
public class NextGreaterElement {

    public static int[] nextGreaterElementArray(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int len = arr.length;
        int[] answer = new int[len];
        answer[len-1] = -1;
        stack.push(arr[len-1]);

        for(int i=len-2;i>=0;i--) {
            while (!stack.isEmpty() && stack.peek() < arr[i]) stack.pop();
            if(stack.isEmpty()) answer[i] = -1;
            else answer[i] = stack.peek();
            stack.push(arr[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,9,3,1,12,6,8,7};
        Arrays.stream(nextGreaterElementArray(arr)).forEach(i -> System.out.print(i+" "));

    }
}
