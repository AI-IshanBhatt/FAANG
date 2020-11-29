package datastructures.array.Arrangment;

import java.util.Arrays;

public class RearrangePosNeg {

    public static void main(String[] args) {

        int[] arr = new int[]{-5, -2, 5, 2, 4, 7, 1, 8, 2, -8};
        rearrange(arr);
        Arrays.stream(arr).forEach(x -> System.out.print(x+" "));

    }

    public static void rearrange(int[] arr) {
        int currentPos = -1;
        int currentNeg = -1;

        for(int i=0;i<arr.length;i++) {
            if(arr[i] > 0 && i%2==0 && currentNeg==-1) continue;
            if(arr[i] < 0 && i%2!=0 && currentPos==-1) continue;

            if(arr[i] > 0 && i%2!=0) {
                if(currentNeg >= 0) {
                    swap(arr, currentNeg, i);
                    currentPos = -1;
                    currentNeg = -1;
                }
                else
                    if (currentPos == -1)
                        currentPos = i;
            }

            if(arr[i] < 0 && i%2==0) {
                if(currentPos >= 0) {
                    swap(arr, currentPos, i);
                    currentPos = -1;
                    currentNeg = -1;
                }
                else currentNeg = i;
            }
        }

    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
