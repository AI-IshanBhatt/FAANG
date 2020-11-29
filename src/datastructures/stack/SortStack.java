package datastructures.stack;

import java.util.Stack;
// https://www.geeksforgeeks.org/sort-a-stack-using-recursion/
public class SortStack {

    Stack<Integer> st = new Stack<>();

    public void push(int ele) {
        st.push(ele);
    }

    public void sortStack() {
        if(! st.empty()) {
            int ele = st.pop();
            sortStack();
            putAtRightPlace(ele);
        }
    }

    public void putAtRightPlace(int ele) {
        if(st.isEmpty()) {
            st.push(ele);
        } else {
            int x = st.pop();
            if(x > ele) {
                putAtRightPlace(ele);
                st.push(x);
            } else {
                putAtRightPlace(x);
                st.push(ele);
            }
        }
    }


    public static void main(String[] args) {
        SortStack sortStack = new SortStack();
        sortStack.push(30);
        sortStack.push(-5);
        sortStack.push(18);
        sortStack.push(14);
        sortStack.push(-3);
        sortStack.sortStack();
        System.out.println(sortStack.st);
    }
}
