package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/matrix-block-sum/
public class MatrixBlockSum {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int k = 2;
        int[][] answer = matrixBlockSum(mat, k);

        for(int i=0;i<answer.length;i++) {
            for(int j=0;j<answer[0].length;j++) {
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] answer = new int[rows][cols];

        List<List<Integer>> rowElements = elements(rows, k);
        List<List<Integer>> columnElements = elements(cols, k);

        List<Integer> rowIndex;
        List<Integer> columnIndex;

        int sum =0;

        for(int i=0;i<rows;i++) {
            rowIndex = rowElements.get(i);
            for(int j=0;j<cols;j++) {
                columnIndex = columnElements.get(j);
                for(int l:rowIndex) {
                    for(int m:columnIndex) sum+=mat[l][m];
                }
                answer[i][j] = sum;
                sum=0;
            }
        }

        return answer;
    }

    public static List<List<Integer>> elements(int rc, int k) {
        List<List<Integer>> elements = new ArrayList<>();
        int start = 0, end=0;
        for(int r=0;r<rc;r++) {
            List<Integer> rowValues = new ArrayList<>();
            start = r - k;
            end = r + k;
            for(int j=start;j<=end;j++) {
                if(j>=0 && j<rc) rowValues.add(j);
            }
            elements.add(rowValues);
        }
        return elements;

    }
}
