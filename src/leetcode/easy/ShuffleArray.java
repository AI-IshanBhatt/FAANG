package leetcode.easy;

/*
* https://leetcode.com/problems/shuffle-the-array/
* */

import java.util.ArrayList;
import java.util.List;

public class ShuffleArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,4,3,2,1};
        int num = 4, counter=0;
        int[] answer = new int[arr.length];

//        List<Integer> answer = new ArrayList<>();
//
//        for(int i=0;i<num;i++) {
//            answer.add(arr[i]);
//            answer.add(arr[num+i]);
//        }

        for(int i=0;i<num;i++) {
            answer[counter++] = arr[i];
            answer[counter++] = arr[num+i];

        }

        for(int ele: answer) System.out.print(ele);
        System.out.println();
        int[] x = usingSameArray(arr, num);
        for(int ele: x) System.out.print(ele);

    }

    public static int[] usingSameArray(int[] nums, int n) {
        int max = 1001, counter=0;

//        Store nums[i] and nums[n+i] at the same location
//        You can fill the array in the back=side as well
//        ALWAYS FILL THE ARRAY IN BACKSIDE IF YOU WANT TO STORE 2 ELEMENTS AT SAME INDEX
//        SO THAT ITERATING FROM FRONT DOES NOT SCREW=UP THE INDEX
//        THE PROBLEMS IN WHICH YOU THINK, YOU MIGHT LOSE THE ELEMENT IN TRAVERSAL, THIS IS A NINJA TECHNIQUE

        for(int i=0;i<n;i++) {
            nums[n+i] = max*nums[i] + nums[n+i];
        }

        for(int i=0;i<n;i++) {
            nums[counter++] = nums[n+i] / max;
            nums[counter++] = nums[n+i] % max;
        }


        return nums;
    }

}
