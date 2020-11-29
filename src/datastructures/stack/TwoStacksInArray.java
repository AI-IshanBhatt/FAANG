package datastructures.stack;

// https://www.geeksforgeeks.org/implement-two-stacks-in-an-array/
import java.util.Arrays;

public class TwoStacksInArray {

    public static int[] globalArray = new int[6];

    static class DoubleStack {
        int s1Last = 0;
        int s2Last = globalArray.length-1;

        public void push(int element, String stackName) {
            if(stackName.equals("s1")) {
                if(s1Last < s2Last) {
                    globalArray[s1Last] = element;
                    s1Last++;
                } else System.out.println("Going to step into s2's territory");
            } else if(stackName.equals("s2")) {
                if(s2Last > s1Last) {
                    globalArray[s2Last] = element;
                    s2Last--;
                } else System.out.println("Going to step into s1's territory");

            } else System.out.println("Provide Stack Name as either s1 or s2");
        }

        public int pop(String stackName) {
            if(stackName.equals("s1")) {
                return globalArray[--s1Last];  // In actual interview make sure you handle empty stack
            } else if(stackName.equals("s2")) {
                return globalArray[++s2Last];
            } else return Integer.MAX_VALUE;
        }

    }

    public static void main(String[] args) {
        DoubleStack d = new DoubleStack();
        d.push(1, "s1");
        d.push(2, "s1");
        d.push(3, "s1");
        d.push(4, "s1");
        d.push(500, "s2");
        d.push(600, "s2");
        Arrays.stream(globalArray).forEach(i -> System.out.print(i+" "));
        System.out.println();
        System.out.println(d.pop("s2"));
        d.push(600, "s2");
        Arrays.stream(globalArray).forEach(i -> System.out.print(i+" "));
        System.out.println();
        System.out.println(d.pop("s1"));
        d.push(99, "s1");
        Arrays.stream(globalArray).forEach(i -> System.out.print(i+" "));
        d.push(999, "s2");
    }
}
