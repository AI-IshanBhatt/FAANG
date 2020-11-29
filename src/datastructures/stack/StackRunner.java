package datastructures.stack;

public class StackRunner {

    public static void main(String[] args) {
        CustomStack<Integer> cs = new CustomStack<>(10);
        cs.push(1);
        cs.push(2);
        cs.push(3);
        cs.printStack();
        System.out.println(cs.top());
        cs.pop();
        System.out.println(cs.top());
        cs.push(4);
        cs.push(5);
        System.out.println(cs.top());
        cs.pop();
        System.out.println(cs.top());

    }
}
