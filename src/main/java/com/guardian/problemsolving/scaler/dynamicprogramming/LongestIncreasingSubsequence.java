package com.guardian.problemsolving.scaler.dynamicprogramming;

import java.util.Arrays;

//Need greedy approach here with binary search to avoid TLE
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] A={14, 24, 18, 46, 55, 53, 82, 18, 101, 20, 78, 35, 68, 9, 16, 93, 101, 85, 81, 28, 78};
        System.out.print(lis(A));
    }
    private static int lis(final int[] A) {
        int N=A.length;
        int[] dp=new int[N];
        Arrays.fill(dp,1);
        int lis=1;

        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(A[i]>A[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
            lis=Math.max(lis,dp[i]);
        }
        return lis;
    }
}
