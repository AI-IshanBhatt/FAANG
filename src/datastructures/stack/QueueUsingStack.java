package datastructures.stack;

// https://www.geeksforgeeks.org/queue-using-stacks/
// IMPLEMENTATION USING FUNCTION-CALL, RECURSION REMAINS
public class QueueUsingStack {

    static class QueueOfStack {
        CustomStack<Integer> s1 = new CustomStack<>(10);
        CustomStack<Integer> s2 = new CustomStack<>(10);

        public void push(int i) {
            while (!s2.isEmpty()) s1.push(s2.pop());
            s1.push(i);
        }

        public int deque() {
            while(!s1.isEmpty()) s2.push(s1.pop());
            return s2.pop();
        }

    }

    public static void main(String[] args) {

        QueueOfStack q = new QueueOfStack();
        q.push(10);
        q.push(20);
        q.push(30);
        System.out.println(q.deque());
        q.push(0);
        System.out.println(q.deque());
        System.out.println(q.deque());
        System.out.println(q.deque());

    }
}
