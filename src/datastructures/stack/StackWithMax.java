package datastructures.stack;

import java.util.Stack;
// This is similar to StackWithMin.java but now we want to get max element in O(1) time and space.
// The thing to grasp here is that putting a value lower than current max is straight forward
// as it does not require any change to the current maximum
public class StackWithMax {

    public Stack<Integer> stack = new Stack<>();
    int maxEle;

    public void push(int x) {
        if(stack.isEmpty()) {stack.push(x); maxEle=x;}
        else {
            if(x < maxEle) stack.push(x);
            else {
                stack.push(2*x - maxEle);
                maxEle = x;
            }
        }
    }

    public int pop() {
        int poppedEle = stack.pop();
        if(poppedEle < maxEle) return poppedEle;
        else {
            int currentMax = maxEle;
            maxEle = 2*currentMax - poppedEle;
            return currentMax;
        }
    }

    public int getMax() {
        return maxEle;
    }

    public static void main(String[] args) {
        StackWithMax s = new StackWithMax();
        s.push(5);
        s.push(7);
        s.push(6);
        s.push(8);
        s.push(1);
        s.push(3);
        s.push(2);
        s.push(9);
        s.push(4);

        int poppedElement;
        System.out.println(s.getMax());
        while(! s.stack.isEmpty()) {
            poppedElement = s.pop();
            System.out.println("POPPED "+poppedElement+" MAX "+s.getMax());
        }
    }
}
