package com.guardian.problemsolving.scaler.basics;

import java.util.HashMap;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        int[] A={1,3,0,4,1};
        int k=5;
        System.out.print(checkSubarraySum(A,k));
    }
    static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        sumMap.put(0,-1);
        int sum=0;

        for(int i=0;i<nums.length;i++){
            if(k!=0){
                sum+=nums[i]%k;
                sum%=k;
            }
            else
                sum+=nums[i];

            Integer prev=sumMap.get(sum);
            if(prev!=null){
                if(i-prev>1)
                    return true;
            }
            else
                sumMap.put(sum,i);
        }
        return false;
    }
}
