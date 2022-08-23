package com.guardian.problemsolving.leetcode.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target=9;
        Arrays.stream(twoSum(nums,target)).forEach(e->System.out.print(e+" "));
    }
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i]))
                return Stream.of(hm.get(target-nums[i]),i).mapToInt(Integer::intValue).toArray();
            else
                hm.put(nums[i],i);
        }
        return new int[0];
    }
}
