package leetcode.easy;

/*
* https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
* */


public class KidsCandies {

    public static void main(String[] args) {

        int[] candies = new int[]{2,3,5,3,1};
        boolean[] answer = new boolean[candies.length];
        int extraCandies = 3, maxCandies=0;

        for(int ele:candies) {
            if(ele > maxCandies) maxCandies=ele;
        }

        for(int i=0;i< candies.length; i++) {
            answer[i] = candies[i] + extraCandies >= maxCandies;
        }

//        int maxCandies = Arrays.stream(candies).max().getAsInt();
////        boolean[] resultArray = new boolean[candies.length];
////        IntStream.range(0, candies.length).forEach(i -> resultArray[i] = candies[i] + extraCandies >= maxCandies);
//
////        mapToObj.collect(Collectors.toList()) will correctly convert it to List<Boolean>
//        List<Boolean> answer = Arrays.stream(candies).mapToObj(i -> i+extraCandies>=maxCandies).collect(Collectors.toList());
    }
}
