package datastructures.array.Arrangment;

import java.util.Arrays;

// You can use similar techniques to move all -ve, +ve numbers to end
// Idea is to increase count(NON ZERo) pointer not the other way around
public class MoveZeroToLast {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 0, 5, 0, 3, 6};
        moveZeros(arr);
        Arrays.stream(arr).forEach(x -> System.out.print(x+" "));
    }

    public static void moveZeros(int[] arr) {

        int count = 0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] != 0) {
                swap(arr, count++, i);
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
