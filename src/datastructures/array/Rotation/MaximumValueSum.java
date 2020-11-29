package datastructures.array.Rotation;

import java.util.Arrays;

//https://www.geeksforgeeks.org/find-maximum-value-of-sum-iarri-with-only-rotations-on-given-array-allowed/
public class MaximumValueSum {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(findMaxSum(arr));
    }

    public static int findMaxSum(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int currentSum = 0, maxSum;

        for(int i=0;i< arr.length;i++)
        {
            currentSum += (i*arr[i]);
        }
        maxSum = currentSum;
        for(int i=0;i< arr.length-1;i++)
        {
            currentSum = currentSum - sum + arr.length*arr[i];
            if (currentSum > maxSum) maxSum = currentSum;
        }
        return maxSum;
    }
}
