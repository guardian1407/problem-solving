package com.guardian.problemsolving.scaler.arrays;

import java.util.Arrays;

public class MaximumDifference {
    public static void main(String[] args) {
        int[] A={93, 51, 84, 81, 89, 82, 28, 78, 86, 35, 64, 38, 49, 99, 83};
        int B=4;
        System.out.print(solve(A,B));
    }

    private static int solve(int[] A, int B) {
        int n=A.length;
        Arrays.sort(A);
        long[] psa=new long[n];
        psa[0]=A[0];
        for(int i=1;i<n;i++)
            psa[i]=psa[i-1]+A[i];
        long min=psa[B-1];
        long max=psa[n-1]-psa[n-B-1];
        int res1=(int)Math.abs(psa[n-1]-2*min);
        int res2=(int)Math.abs(psa[n-1]-2*max);
        return Math.max(res1,res2);
    }
}
