package leetcode.easy;

public class FlipImage {

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        a = flipAndInvertImage(a);
        for(int[] r: a){
            for(int ele:r) System.out.print(ele+" ");
            System.out.println();
        }

    }

    public static int[][] flipAndInvertImage(int[][] a) {

        for(int[] r:a) {
            reverseArray(r);
            for(int i=0;i<r.length;i++) r[i] = 1-r[i];
        }
        return a;
    }

    public static void reverseArray(int[] a) {
        int len = a.length;
        int iteration = a.length/2, temp;
        for(int i=0;i<iteration;i++) {
            temp = a[i];
            a[i] = a[len-i-1];
            a[len-i-1] = temp;
        }
    }
}
