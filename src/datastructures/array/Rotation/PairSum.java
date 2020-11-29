package datastructures.array.Rotation;

import java.util.*;
//https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/
public class PairSum {

    public static class Tuple {
        public final int x;
        public final int y;
        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,8,9,0,1,2,3,4,5,6};
//      3,4,5,6,7,8,9,0,1,2,3
        int sum = 14;
        int pivot = findPivot(arr, 0, arr.length);
        boolean answer = findSumTwoPointers(Arrays.copyOfRange(arr, 0, pivot), sum)
                || findSumTwoPointers(Arrays.copyOfRange(arr, pivot, arr.length), sum);

        System.out.println("SUM FOUND "+answer);
//        System.out.println(sumExists(arr, sum));
//
//        System.out.println(sumPair(arr, sum));

    }

    public static int findPivot(int[] arr, int start, int end) {
        int mid = (start + end) / 2;

        if(arr[mid-1] > arr[mid])
            return mid;

        if (arr[mid] > arr[start])
            return findPivot(arr, mid, end);
        else
            return findPivot(arr, start, mid);

    }

    public static boolean sumExists(int[] arr, int sum) {
        Set<Integer> s = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            if(s.contains(arr[i])) return true;
            s.add(sum - arr[i]);
        }
        return false;
    }

    public static Tuple sumPair(int[] arr, int sum) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            if(m.containsKey(arr[i])) return new Tuple(m.get(arr[i]), i);
            m.put(sum - arr[i], i);
        }
        return new Tuple(-1,-1);
    }
//    FOR FINDING SUM IN SORTED/ ROTATED ARRAY TWO POINTER TECHNIQUE IS THE GO=TO SOLUTION
    public static boolean findSumTwoPointers(int [] arr, int sum) {
        int firstPointer = 0;
        int lastPointer = arr.length - 1;
        int currentSum = 0;

        while (true) {
            currentSum = arr[firstPointer] + arr[lastPointer];
            if (currentSum == sum) return true;
            if(sum > currentSum) firstPointer ++;
            else lastPointer --;
            if (firstPointer >= lastPointer) return false;  //  We could not find th element
        }
    }

}
