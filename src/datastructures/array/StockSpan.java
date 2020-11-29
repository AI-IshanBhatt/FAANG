package datastructures.array;

import java.util.Arrays;
import java.util.Stack;

// https://www.geeksforgeeks.org/the-stock-span-problem/
// In a way is is finding previous large element's index
public class StockSpan {

    public static int[] getStockSpan(int[] arr) {
        int len = arr.length;
        int[] answer = new int[len];
        answer[0] = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);


        for(int i=1;i<len;i++){
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) stack.pop();
            if(stack.isEmpty()) answer[i] = i+1;
            else answer[i] = i-stack.peek();
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{100, 80, 60, 70, 60, 75, 85};
        int[] expected = new int[]{1,1,1,2,1,4,6};
        Arrays.stream(getStockSpan(arr)).forEach(i -> System.out.print(i+" "));
    }
}
