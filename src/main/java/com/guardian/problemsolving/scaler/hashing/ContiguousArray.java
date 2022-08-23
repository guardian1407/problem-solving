package com.guardian.problemsolving.scaler.hashing;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static void main(String[] args) {
        int[] A={0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1};
        System.out.print(solve(A));
    }
    static int solve(int[] A) {
        Map<Integer,Integer> hm=new HashMap<>();
        hm.put(0,-1);
        int sum=0;
        int maxLen=0;

        for(int i=0;i<A.length;i++){
            if(A[i]==0) sum+=-1;
            else sum+=1;

            Integer startIndex=hm.get(sum);

            if(startIndex==null)
                hm.put(sum,i);
            else
                maxLen=Math.max(maxLen,i-startIndex);
        }
        return maxLen;
    }
}
