package com.guardian.problemsolving.scaler.greedyalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElement {
    public static void main(String[] args) {
        int[] A={2, 1, 2};
        System.out.print(majorityElement(A));
    }
    private static int majorityElement(final int[] A) {
        int me=A[0];
        int count=1;

        for(int i=1;i<A.length;i++){
            if(count==0){
                me=A[i];
                count++;
            }
            else{
                if(A[i]==me)
                    count++;
                else
                    count--;
            }
        }
        return me;
    }

    //This below one is from leetcode Majority Element II
    public List<Integer> majorityElement2(int[] nums) {
        int num;
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < n; ){
            int freq = 0;
            num = nums[i];
            while(i < n && nums[i] == num){
                i++;
                freq++;
            }
            if(freq * 3 > n)
                result.add(num);
        }
        return result;
    }
}
