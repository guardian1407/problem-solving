package com.guardian.problemsolving.leetcode.arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public static void main(String[] args) {
        int[] nums={41,84,80,54,7,94,38,16,27,6,39,9,9,39,38,95,20,53,72,32,16,1,71,4,75,27,72,58,21,99,90,79,65,4,48,25,44,12,26,73,86,55,75,24,63,13};
        Stream.of(smallerNumbersThanCurrent(nums)).forEach(e -> System.out.print(Arrays.toString(e) + " "));
    }
    //this is freq array approach; can also be done using sorting and hashmap
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq=new int[102];
        for (int num : nums) {
            freq[num]++;
        }
        int sum=0;
        for(int i=1;i<freq.length;i++){
            int prevCount=freq[i-1];
            freq[i-1]=sum;
            sum+=prevCount;
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=freq[nums[i]];
        }
        return nums;
    }
}
