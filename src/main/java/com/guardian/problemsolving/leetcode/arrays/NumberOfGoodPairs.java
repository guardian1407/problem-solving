package com.guardian.problemsolving.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {
    public static void main(String[] args) {
        int[] nums={1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(nums));
    }
    public static int numIdenticalPairs(int[] nums) {
        int res=0;
        Map<Integer,Integer> hm=new HashMap<>();
        for(int e:nums){
            int pairs=hm.getOrDefault(e,0);
            res+=pairs;
            hm.put(e,pairs+1);
        }
        return res;
    }
}
