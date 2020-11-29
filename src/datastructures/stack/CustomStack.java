package datastructures.stack;

import java.util.ArrayList;
import java.util.List;

public class CustomStack<T> {

    private List<T> stack = new ArrayList<>();
    private int size;
    private int currentIndex;
    public CustomStack(int size) {
        this.size = size;
    }

    public void push(T element) {
        if(stack.size() >= this.size) {
            System.out.println("Stack is full, please pop something before pushing");
        } else {stack.add(element); currentIndex++;};
//  Don't do the trick like remove as adding element at particular position is expansive operation in ArrayList
    }

    public T pop() {
        if(currentIndex == 0) {
            throw new IllegalArgumentException("Stack is empty push something");
        } else return stack.remove(--currentIndex);
    }

    public void printStack() {
        stack.forEach(t -> System.out.print(t+" "));
        System.out.println();
    }

    public boolean isEmpty() {return stack.isEmpty();}

    public boolean isFull() {return this.size == stack.size();}

    public T top() {
        return stack.get(currentIndex-1);  // Needed to do like this
        // because we don't want to change currentIndex in case of top
    }
}
