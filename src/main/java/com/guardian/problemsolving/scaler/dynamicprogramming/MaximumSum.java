package com.guardian.problemsolving.scaler.dynamicprogramming;

public class MaximumSum {
    public static void main(String[] args) {
        int[] A={1, 5, -3, 4, -2};
        int B=2;
        int C=1;
        int D=-1;
        System.out.print(solve(A,B,C,D));
    }
    private static int solve(int[] A, int B, int C, int D) {
        int N=A.length;
        int[] left=new int[N];
        left[0]=B*A[0];
        for(int i=1;i<N;i++)
            left[i]=Math.max(left[i-1],B*A[i]);

        int[] right=new int[N];
        right[N-1]=D*A[N-1];
        for(int i=N-2;i>=0;i--)
            right[i]=Math.max(right[i+1],D*A[i]);

        int ans=Integer.MIN_VALUE;
        for(int i=0;i<N;i++)
            ans=Math.max(ans,left[i]+C*A[i]+right[i]);

        return ans;
    }
}
