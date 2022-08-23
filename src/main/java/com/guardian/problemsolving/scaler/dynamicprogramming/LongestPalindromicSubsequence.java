package com.guardian.problemsolving.scaler.dynamicprogramming;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String A="bebeeed";
        System.out.print(solve(A));
    }
    private static int solve(String A) {
        int N=A.length();
        int[][] dp=new int[N][N];

        for(int i=0;i<N;i++)
            dp[i][i]=1;

        for(int j=1;j<N;j++)
            for(int row=0,col=j;row<N && col<N;row++,col++)
                dp[row][col]=A.charAt(row)==A.charAt(col) ? 2+dp[row+1][col-1] : Math.max(dp[row][col-1],dp[row+1][col]);

        return dp[0][N-1];
    }
}
