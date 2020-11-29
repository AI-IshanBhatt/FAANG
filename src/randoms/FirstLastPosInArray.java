package randoms;

// https://www.youtube.com/watch?v=dVXy6hmE_0U

import java.util.ArrayList;
import java.util.List;

public class FirstLastPosInArray {

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,6,7,7,8,8,8,9};
        int ele=8;
        System.out.println(findIndex(arr, ele));
        System.out.println(findIndex(arr, ele+1)-1);
    }

    public static int findIndex(int[] arr, int ele) {
        int mid=0,j,k, start=0, end=arr.length;
        int firstPos=-1;

        while(start < end) {
            mid = (start+end)/2;
            if(arr[mid] >= ele) {
                firstPos = mid;  // In normal Binary Search you would have returned the mid here
                end = mid-1;  // Because you are finding the first position the we look on the left side
                              // For last position we would have searched right by making start=mid+1
            } else if(arr[mid] < ele) {
                start = mid+1;
            }
        }

        return firstPos;
    }

}
