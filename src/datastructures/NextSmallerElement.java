package datastructures;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    public static int[] nextSmallerElement(int[] arr) {
        int len = arr.length;
        int[] answer = new int[len];
        answer[len-1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[len-1]);

        for(int i=len-2;i>=0;i--) {
            while(!stack.isEmpty() && arr[i] < stack.peek()) stack.pop();
            if(stack.isEmpty()) answer[i] = -1;
            else answer[i] = stack.peek();
            stack.push(arr[i]);
        }
        return answer;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,9,3,1,12,6,8,7};
        int[] expected = new int[]{1,3,3,1,-1,6,-1,7,-1};
        Arrays.stream(nextSmallerElement(arr)).forEach(i -> System.out.print(i+" "));
    }
}
