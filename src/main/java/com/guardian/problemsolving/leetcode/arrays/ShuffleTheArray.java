package com.guardian.problemsolving.leetcode.arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class ShuffleTheArray {
    public static void main(String[] args) {
        int[] nums={2,5,1,3,4,7};
        int n=3;
        Stream.of(shuffle(nums, n)).forEach(e->System.out.print(Arrays.toString(e) +" "));
    }
    public static int[] shuffle(int[] nums, int n) {
        int[] res=new int[2*n];

        for(int i=0;i<n;i++){
            res[i*2]=nums[i];
        }
        for(int i=n;i<2*n;i++){
            res[2*i-2*n+1]=nums[i];
        }
        return res;
    }
}
