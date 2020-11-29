package datastructures.array;

import java.util.Stack;
import java.util.Arrays;

public class PreviousSmallerElement {

    public static int[] previousSmallerElementArray(int[] arr) {
        int len = arr.length;
        int[] answer = new int[len];
        answer[0] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for(int i=1;i<len;i++) {
            while(!stack.isEmpty() && arr[i] < stack.peek()) stack.pop();
            if(stack.isEmpty()) answer[i] = -1;
            else answer[i] = stack.peek();
            stack.push(arr[i]);
        }
        return answer;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,7,3,4,1,9,8,5,6};
        int[] expected = new int[]{-1,2,2,3,-1,1,1,1,5};

        Arrays.stream(previousSmallerElementArray(arr)).forEach(value -> System.out.print(value+" "));
    }
}
