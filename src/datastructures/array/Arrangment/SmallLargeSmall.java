package datastructures.array.Arrangment;

import java.util.Arrays;

public class SmallLargeSmall {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 9, 2, 8, 3, 7, 4, 6, 5};
        arr = rearrange(arr);
        Arrays.stream(arr).forEach(x -> System.out.print(x+ " "));
    }

    public static int[] rearrange(int[] arr) {

        Arrays.sort(arr);
        int[] answer = new int[arr.length];

        int i = 0,j= arr.length-1;
        for(int k=0;k< arr.length;k++) {
            if(k%2==0) {
                answer[k] = arr[i];
                i++;
            } else {
                answer[k] = arr[j];
                j--;
            }
        }
        return answer;
    }

    public static void swap(int[] arr, int a, int b) {

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
