package com.guardian.problemsolving.scaler.arrays;

import java.util.Arrays;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        int[] A={5, 17, 100, 11};
        System.out.print(solve(A));
    }
    private static int solve(int[] A) {
        Arrays.sort(A);
        int ans=A[1]-A[0];
        int l=0; int r=1;

        while(r<A.length)
            ans=Math.min(ans,A[r++]-A[l++]);

        return ans;
    }
}
