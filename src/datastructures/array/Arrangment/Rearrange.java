package datastructures.array.Arrangment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://www.geeksforgeeks.org/rearrange-array-arri/
public class Rearrange {

    public static void main(String[] args) {
        int[] arr = new int[]{-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        rearrange(arr);
        Arrays.stream(arr).forEach(x -> System.out.print(x+" "));

    }

    public static void rearrange(int[] arr) {
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<arr.length;i++) s.add(arr[i]);

        for(int i=0;i<arr.length;i++) {
            if(s.contains(i)) arr[i] = i;
            else arr[i] = -1;
        }

    }
}
