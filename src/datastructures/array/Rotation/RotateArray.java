package datastructures.array.Rotation;

import java.util.Arrays;
import java.util.stream.Stream;

//https://www.geeksforgeeks.org/array-rotation/
public class RotateArray {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};

        int rotation = 2;
        rotate(arr, rotation);
//        int rotation = ;
//        int[] firstHalf = Arrays.copyOfRange(arr, 0, rotation);
//        int[] secondHalf = Arrays.copyOfRange(arr,rotation, arr.length);
//
//        reverseArray(firstHalf);
//        reverseArray(secondHalf);
//
//        System.arraycopy(firstHalf,0,arr,0,firstHalf.length);
//        System.arraycopy(secondHalf, 0, arr, firstHalf.length, secondHalf.length);
//
//        reverseArray(arr);
//        Arrays.stream(arr).forEach(value -> System.out.print(value +" "));
//        reverseArrayWithIndex(arr, 0, 7);
//        reverseArrayWithIndex(arr, 7, arr.length);
//        reverseArrayWithIndex(arr, 0, arr.length);
        Arrays.stream(arr).forEach(value -> System.out.print(value +" "));


    }

    public static void rotate(int[] arr, int rotation) {
        int len = arr.length;

        int iterations = gcd(len, rotation);
        int j,k,l,m,temp;

        for(int i=0; i< iterations; i++) {
            temp = arr[i];
            j = i;

            while (true) {
                k = j + rotation;
                if (k >= len) k=k-len;
                if(k == i) break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }


    }

    public static int gcd(int n1, int n2) {
        if(n2 == 0) return n1;
        else return gcd(n2, n1%n2);
    }

    public static void reverseArray(int[] arr) {
        int len = arr.length - 1;
        int rotation = arr.length / 2,temp;
        for(int i=0; i<rotation; i++) {
            temp = arr[i];
            arr[i] = arr[len - i];
            arr[len - i] = temp;
        }
    }

    public static void reverseArrayWithIndex(int[] arr, int startPosition, int rotation) {
        int iteration = startPosition + rotation / 2, temp;
        int len = startPosition + rotation - 1;
        for(int i =startPosition; i< iteration; i++) {
            temp = arr[i];
            arr[i] = arr[len-i];
            arr[len-i] = temp;
        }

    }
}
