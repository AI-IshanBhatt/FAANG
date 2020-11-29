package leetcode.easy;

/*
* https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
* Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
* That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallerThanCurrent {

    public static void main(String[] args) {

        int[] arr = new int[]{8,1,2,2,3};
        int[] dummy = arr.clone();
        Arrays.sort(dummy);

        Map<Integer, Integer> m = new HashMap<>();
        int count=0;

        for(int i=0;i<dummy.length;i++) {
            if(m.containsKey(dummy[i])) continue;
            else {
                m.put(dummy[i], count);
                count++;
            }
        }

        for(int i=0;i<arr.length;i++) arr[i] = m.get(arr[i]);

        Arrays.stream(arr).forEach(i -> System.out.print(i+" "));
    }
}
