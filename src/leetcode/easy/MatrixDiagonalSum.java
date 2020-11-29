package leetcode.easy;

public class MatrixDiagonalSum {

    public static void main(String[] args) {

        int[][] mat = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] mat1 = new int[][]{{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}};
        int[][] mat2 = new int[][]{{5}};

        System.out.println(diagonalSum(mat2));
    }

    public static int diagonalSum(int[][] mat) {

        int i=0,j=0; // For Primary
        int m=0,n=mat.length-1; // For Secondary

        int sum = 0;

        while(i< mat.length && m < mat.length) {
            if(i==m && j==n) sum += mat[i][j];
            else sum += mat[i][j] + mat[m][n];

            i++;
            j++;
            m++;
            n--;
        }

        return sum;

    }
}
