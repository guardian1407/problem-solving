package com.guardian.problemsolving.scaler.dynamicprogramming;

public class MaxSumWithoutAdjacentElements {
    public static void main(String[] args) {
        int[][] A={{1, 2, 3, 4},{2, 3, 4, 5}};
        System.out.print(adjacent(A));
    }
    private static int adjacent(int[][] A) {
        return maxSum(A,A[0].length-1,new int[A[0].length]);
    }
    private static int maxSum(int[][] A,int i,int[] dp){
        if(i==0)
            return Math.max(A[0][0],A[1][0]);
        else if(i==1)
            return Math.max(A[0][0],Math.max(A[1][0],Math.max(A[0][1],A[1][1])));
        else{
            if(dp[i]==0)
                dp[i]=Math.max(maxSum(A,i-1,dp),Math.max(maxSum(A,i-2,dp)+A[0][i],maxSum(A,i-2,dp)+A[1][i]));
            return dp[i];
        }
    }
}
