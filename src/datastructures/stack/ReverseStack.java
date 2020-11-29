package datastructures.stack;

// https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
import java.util.Stack;

public class ReverseStack {

    Stack<Integer> st = new Stack<>();

    public void reverse() {
        if(! st.empty()) {
            int x = st.pop();  // This x is stored in the frame and will be used in auxFun in recursion
            reverse();
            insertAtBottom(x);
        }
    }

    public void insertAtBottom(int element) {
        if(st.isEmpty()) {
            st.push(element);
        }
        else {
            int x = st.pop();  // x will remain in the Function Stack and is accessed at 28,
                               // Either we reach line 28 by 22(if) OR 28(else)
            insertAtBottom(element);
            st.push(x);
        }
    }

    public void push(int element) {
        st.push(element);
    }

    public static void main(String[] args) {
        ReverseStack rs = new ReverseStack();
        rs.push(3);
        rs.push(5);
        rs.push(7);
        rs.push(4);
        rs.reverse();
        System.out.println(rs.st);
    }
}
