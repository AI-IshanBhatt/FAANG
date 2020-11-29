package datastructures.array.Rotation;

//https://www.geeksforgeeks.org/c-program-cyclically-rotate-array-one/
public class SearchRotated {

    public static void main(String[] args) {
        int[] a = new int[]{3,4,5,6,7,8,9,1,2};
        int[] b = new int[]{7,8,9,0,1,2,3,4,5,6};
        int answer = findPivot(a, 0, a.length);
        System.out.println("Array Pivoted from "+answer);
        int element = 2, index, len=a.length-1;
        if (element > a[len])
            index = binarySearch(a, element, 0, answer);
        else
            index = binarySearch(a, element, answer, len);

        System.out.println("Element "+element +" found at "+index);


    }

    public static int findPivot(int[] arr, int start, int end) {
        int mid = (start + end) / 2;

        if(arr[mid-1] > arr[mid])
            return mid;
        if (arr[mid] > arr[start])
            return findPivot(arr, mid, end);
        else
            return findPivot(arr, start, mid);
    }

    public static int binarySearch(int[] arr, int element, int start, int end) {
        int mid = (start + end) / 2;

        if (arr[mid] == element)
            return mid;
        if (start >= end)
            return -1;

        if (element > arr[mid])
            return binarySearch(arr, element, mid+1, end);
        else
            return binarySearch(arr, element, start, mid);
    }
}
