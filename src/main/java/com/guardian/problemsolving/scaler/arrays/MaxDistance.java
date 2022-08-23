package com.guardian.problemsolving.scaler.arrays;

public class MaxDistance {
    public static void main(String[] args) {
        int[] A = {3, 5, 4, 2};
        System.out.println(maximumGap(A));
    }
    private static int maximumGap(final int[] A){
        int N=A.length;
        int maxDiff=Integer.MIN_VALUE;
        int[] postfixMax=new int[N];
        postfixMax[N-1]=A[N-1];

        for(int i=N-2;i>=0;i--)
            postfixMax[i]=Math.max(postfixMax[i+1],A[i]);

        for(int i=0,j=0;i<N && j<N;){
            if(A[i]<=postfixMax[j]){
                maxDiff=Math.max(maxDiff,j-i);
                j++;
            }
            else
                i++;
        }
        return maxDiff;
    }
}
