package datastructures.BasicTricks;

import java.util.Arrays;

// This technique allows you to store two elements at a single position in an array.
// You can access original element by currentEle%MaxElement, new element by currentEle/MaxElement
// This trick MUST be used on a sorted array
public class MultiplicationModulo {

    public static void main(String[] args) {
        int[] arr = new int[]{15,16,17,18,19,22,25,50};
        multModuArray(arr);
        Arrays.stream(arr).forEach(x -> System.out.print(x+" "));
    }

    public static void multModuArray(int[] arr) {

        int maxIndex = arr.length - 1;
        int maxElement = arr[maxIndex] + 1;

        for(int i=0;i<arr.length;i++) {
            arr[i] += (arr[maxIndex] % maxElement) * maxElement;
            maxIndex--;
        }
    }


}
