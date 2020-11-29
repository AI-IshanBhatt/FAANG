package leetcode.easy;

// https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
public class OddLengthSum {

    public static void main(String[] args) {
        int[] arr = new int[]{10,11,12};
        System.out.println(sumOddLengthSubarrays(arr));
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int sum = 0, odd=3, len=arr.length;
        for(int ele: arr) sum+=ele;
        while(odd <= len) {
            sum += sumSliding(arr, len, odd);
            odd += 2;
        }
        return sum;
    }

    public static int sumSliding(int[] arr, int len, int k) {
        int sum=0, iterations=len-k;

        for(int i=0;i<k;i++) sum+=arr[i];

        int currentSum = sum;

        for(int i=0;i<iterations;i++) {
            currentSum = currentSum - arr[i] + arr[k+i];
            sum += currentSum;
        }

        return sum;
    }

}


