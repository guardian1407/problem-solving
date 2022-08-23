package com.guardian.problemsolving.leetcode.arrays;

public class FindTheHighestAltitude {
    public static void main(String[] args) {
        int[] gain={-5,1,5,0,-7};
        System.out.println(largestAltitude(gain));
    }
    public static int largestAltitude(int[] gain) {
        int res=0;
        int point=0;
        for(int diff:gain){
            point+=diff;
            res=Math.max(res,point);
        }
        return res;
    }
}
