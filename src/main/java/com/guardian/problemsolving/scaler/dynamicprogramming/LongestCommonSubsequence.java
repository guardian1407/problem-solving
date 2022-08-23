package com.guardian.problemsolving.scaler.dynamicprogramming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String A="abbcdgf";
        String B="bbadcgf";
        System.out.print(solve(A,B));
    }
    private static int solve(String A, String B) {
        int[][] dp=new int[A.length()+1][B.length()+1];

        for(int i=1;i<=A.length();i++){
            for(int j=1;j<=B.length();j++){
                if(A.substring(i-1,i).equals(B.substring(j-1,j)))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[A.length()][B.length()];
    }
}
