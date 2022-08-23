package com.guardian.problemsolving.scaler.hashing;

import java.util.HashMap;
import java.util.Map;

public class ShaggyAndDistances {
    public static void main(String[] args){
        int[] A= {7, 1, 3, 4, 1, 7};
        System.out.print(solve(A));
    }
    private static int solve(int[] A){
        int N=A.length;
        Map<Integer,Integer> hm=new HashMap<>();
        int minDist=Integer.MAX_VALUE;
        boolean pairExist=false;

        for(int i=0;i<N;++i){
            if(hm.containsKey(A[i])){
                int j=hm.get(A[i]);
                minDist=Math.min(minDist,i-j);
                hm.put(A[i],i);
                pairExist=true;
            }
            else
                hm.put(A[i],i);
        }
        return pairExist ? minDist : -1;
    }
}
