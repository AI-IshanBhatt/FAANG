package datastructures.BasicTricks;

// This class Shows classic two pointers technique
// Given a sorted array find if there are i,j such that a[i] + a[j] = X
public class TwoPointers {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(findPairTwoPointer(a, 17));
    }

    public static boolean findPairTwoPointer(int[] arr, int sum) {
        int i=0,j= arr.length-1;

        while(i < j) {
            if(arr[i] +arr[j] == sum) return true;

            if(arr[i] + arr[j] < sum) i++;
            else j--;
        }
        return false;
    }
}
