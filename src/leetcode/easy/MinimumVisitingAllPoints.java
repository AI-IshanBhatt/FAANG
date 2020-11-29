package leetcode.easy;
// https://leetcode.com/problems/minimum-time-visiting-all-points/submissions/
public class MinimumVisitingAllPoints {

    public static void main(String[] args) {
        int[][] points = new int[][]{{1,1}, {3,4}, {-1,0}};
        int[][] points1 = new int[][]{{3,2}, {-2,2}};
        System.out.println(minTimeToVisitAllPoints(points1));
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int totalDistance=0;
        for(int i=0; i<points.length-1;i++)
            totalDistance += getMinimumDistance(points[i], points[i+1]);
        return totalDistance;
    }

    public static int getMinimumDistance(int[] begin, int[] end) {

        int xDiff = Math.abs(begin[0] - end[0]);
        int yDiff = Math.abs(begin[1] - end[1]);
        if(xDiff > yDiff) return xDiff;
        else return yDiff;

    }


}
