package datastructures.stack;

// EXTEND BASIC DATA TYPE USING THIS TRICK
// So in coding interview create your custom stack and extend it like this
// We are extending out CurrentStack class with generic type integer
// That's why we atleast have 1 argument constructor of parameter size
public class OptimizedStack extends CustomStack<Integer> {

//  Create a reference of the another stack but do not initialize it as we don't know the size
//  As a rule of thumb, ALWAYS DO THE INITIALIZATION IN THE CONSTRUCTOR
    CustomStack<Integer> minStack;

//  You are using super to access methods/constructor and that in turn initializes the underlying CustomStack
    public OptimizedStack(int size) {
        super(size);  // Keep in mind it just sets the size the underlying ArrayList is filled by push
        minStack = new CustomStack<>(size);
    }

//  Similar to above, Note that you are accessing underlying struct with push, pop methods never using it directly
    public void push(Integer element) {
        super.push(element);  // This push fills the structure/underlying ArrayList
        int currentMin=0;
        if(minStack.isEmpty()) minStack.push(element);
        else {
            currentMin = minStack.top();
            if (element < currentMin) minStack.push(element);
            else minStack.push(currentMin);
        }
    }

    public Integer pop() {
        minStack.pop();
        return super.pop();
    }

    public Integer getMin() {
        return minStack.top();
    }

    public static void main(String[] args) {
        OptimizedStack os = new OptimizedStack(10);
        os.push(3);
        os.push(4);
        System.out.println(os.getMin());
        os.push(0);
        System.out.println(os.getMin());
        os.printStack();
        os.pop();
        System.out.println(os.getMin());
    }
}
