package datastructures.BasicTricks;

import java.util.Arrays;

public class SegmentTree {

    public static void main(String[] args) {
        int[] arr = new int[]{-1,2,4,0};
        int[] segmentTree = new int[7];
        Arrays.fill(segmentTree, 89999);
        createSegmentTree(segmentTree, arr, 0, arr.length-1, 0);
    }

//    Array elements are leaf nodes, keep in mind
//    It has to be recursive function as with most of the tree questions.
//    Fill in left node from left side, right node from right side
    public static void createSegmentTree(int[] segmentTree, int[] arr, int low, int high, int pos) {
//      Leaf nodes of left sub-tree will be filled first, Then their parent then right sub tree their parent
//      And finally from both left and right sub tree root will be filled
//      Surely the terminating condition
        if(low == high) {
            segmentTree[pos] = arr[low];
            return;
        }
        int mid = (low+high)/2;
//        Create full left subtree, So it will be of the form (low=0, mid=1, pos=1)
        createSegmentTree(segmentTree, arr, low, mid, 2*pos+1);
//        Create full right subtree, So it will be of the form (low=1, mid=1, pos=2)
        createSegmentTree(segmentTree, arr, mid+1, high, 2*pos+2);
        segmentTree[pos] = Math.min(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);

    }
}
