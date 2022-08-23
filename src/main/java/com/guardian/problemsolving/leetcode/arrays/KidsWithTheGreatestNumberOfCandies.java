package com.guardian.problemsolving.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public static void main(String[] args) {
        int[] candies={2,3,5,1,3};
        int extraCandies=3;
        kidsWithCandies(candies, extraCandies).forEach(e-> System.out.print(e+" "));
    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for (int candy : candies) {
            max=Math.max(max,candy);
        }
        for (int candy : candies) {
            res.add(candy + extraCandies >= max);
        }
        return res;
    }
}
