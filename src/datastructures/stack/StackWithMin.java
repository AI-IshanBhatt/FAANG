package datastructures.stack;

import java.util.Stack;

// https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
// This is basically extension of what we did in OptimizedStack.java now we are not allowed to use extra space.
// Space complexity has to be O(1)

// This is a very essential trick in your stack manipulation arsenal
public class StackWithMin {

    public Stack<Integer> stack = new Stack<>();
    public int minEle;

    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(x);
            minEle = x;
        } else {
            if(x > minEle) stack.push(x);
            else {
                stack.push(2*x - minEle);
                minEle = x;
            }
        }
    }

    public int pop() {
        int poppedEle = stack.pop();
        if(poppedEle > minEle) return poppedEle;
        else {
            int currentMin = minEle;
            minEle = 2*currentMin - poppedEle;
            return currentMin;
        }
    }

    public int getMin() {
        return minEle;
    }

    public static void main(String[] args) {
        StackWithMin s = new StackWithMin();
        s.push(8);
        s.push(9);
        s.push(5);
        s.push(7);
        s.push(6);
        s.push(4);
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.getMin());
        System.out.println(s.pop()+" "+s.pop()+" "+s.pop());
        System.out.println(s.getMin());
        System.out.println(s.pop());
        System.out.println(s.getMin());

    }
}
