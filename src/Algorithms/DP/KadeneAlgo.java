package Algorithms.DP;

public class KadeneAlgo {

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSumSubArray(arr));
    }

    public static int maxSumSubArray(int[] arr) {

        int len = arr.length;
        int localMax=0;
        int globalMax = Integer.MIN_VALUE;

        for(int i=0;i<len;i++) {
//            This signifies whether you take EITHER the element or SUM LEADING UP TO IT.
//            If the current element is higher than the sum upto it + current element, Take current element only
            localMax = Math.max(arr[i], arr[i]+localMax);
            if(localMax > globalMax) globalMax = localMax;
        }

        return globalMax;
    }
}
