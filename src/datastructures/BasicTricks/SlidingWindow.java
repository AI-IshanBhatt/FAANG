package datastructures.BasicTricks;

// This trick is useful when asked find highest/lowest sum(OPERATION) of K consicutive elements
public class SlidingWindow {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2, 10, 23, 3, 1, 50, 20};
        System.out.println(findKMaxSum(arr,4));
    }

    public static int findKMaxSum(int[] arr, int k) {

        int currentSum = 0;
        int windows = arr.length - k;  // It may look like you need to add 1 in windows but NO
        // As you are calculating the sum of first window in next line so only rest of the windows you need to count
        for(int i=0;i<k;i++) currentSum+=arr[i];

        int maxSum = currentSum;


        for(int i=0;i< windows-1;i++) {
            currentSum = currentSum - arr[i] + arr[k+i];
            if (currentSum > maxSum) maxSum=currentSum;
        }

        return maxSum;
    }


}
