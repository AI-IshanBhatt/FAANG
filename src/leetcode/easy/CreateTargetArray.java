package leetcode.easy;

import java.util.Arrays;

// https://leetcode.com/problems/create-target-array-in-the-given-order/
public class CreateTargetArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int[] index = new int[]{0};

        int[] answer = createTargetArray(nums, index);
        for(int ele: answer) System.out.print(ele);
    }


    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        Arrays.fill(target, -1);

        for(int i=0; i<nums.length;i++) {
            if(target[index[i]] > -1) {
                shuffle(target, index[i], nums[i]);
            } else target[index[i]] = nums[i];
        }

        return target;

    }

//    This is how you shuffle single element, Keep two pointers It doesn't hurt anyone
    public static void shuffle(int[] arr, int index, int num) {
        int temp = arr[index], temp1;
        arr[index] = num;

        index++;
        while(index<arr.length) {
            temp1 = arr[index];
            arr[index] = temp;
            temp=temp1;
            index++;
        }
    }
}
