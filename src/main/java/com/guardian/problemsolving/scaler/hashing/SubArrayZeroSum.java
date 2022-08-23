package com.guardian.problemsolving.scaler.hashing;

import java.util.HashMap;

public class SubArrayZeroSum {
    public static void main(String[] args) {
        int[] A={-78, -97, -44, -18, -7, -26, 37, -76, -23, -35, 48, 9, 25, 62, -90, 27, -40, 18, 88, 82, 15, 96, 31, -2, -45, -48, 52, -78, -79, -76, -18, -88, -85, 58, -48, -48, -16, 77, -79, -89, -78, 27, 98, 53, -6, 43, 73, 38};
        System.out.print(solve(A));
    }
    static int solve(int[] A) {
        HashMap<Long,Integer> hashMap = new HashMap<>();
        hashMap.put(0L,-1);
        long sum=0L;

        for(int i=0;i<A.length;i++){
            sum+=A[i];
            Integer val=hashMap.get(sum);

            if(val==null)
                hashMap.put(sum,i);
            else
                return 1;
        }
        return 0;
    }
}
