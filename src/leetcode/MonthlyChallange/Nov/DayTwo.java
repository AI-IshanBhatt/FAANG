package leetcode.MonthlyChallange.Nov;

// https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3517/
// The insertionSort method will be copied into sorting algos, And we will add for all of them.
public class DayTwo {

    public static void main(String[] args) {
        int[] arr = new int[]{6,5,3,1,8,7,2,4,0,9,-1};
        insertionSort(arr);
        for(int ele: arr) System.out.print(ele+" ");
    }

    public static void insertionSort(int[] arr) {

        int len = arr.length, pivot, temp,j;
        for(int i=0;i<len;i++) {
            pivot = arr[i];  // The current element
            for(j=0;j<i;j++) {
                if(pivot < arr[j]) {
                    temp = arr[j];
                    arr[j] = pivot;
                    pivot = temp;
                }
            }
            arr[j] = pivot;
        }
    }
}
