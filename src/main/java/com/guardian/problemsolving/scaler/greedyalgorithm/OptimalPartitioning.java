package com.guardian.problemsolving.scaler.greedyalgorithm;

import java.util.Arrays;

public class OptimalPartitioning {
    public static void main(String[] args) {
        int[] A={3, 1, 2, 6, 4};
        System.out.println(solve(A));
    }
    private static int solve(int[] A) {
        Arrays.sort(A);
        int ans=Integer.MAX_VALUE;

        for(int i=0,j=1;j<A.length;i++,j++)
            ans=Math.min(ans,A[j]-A[i]);

        return ans;
    }
}
