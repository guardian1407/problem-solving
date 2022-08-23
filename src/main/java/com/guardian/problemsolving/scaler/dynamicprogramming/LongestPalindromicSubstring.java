package com.guardian.problemsolving.scaler.dynamicprogramming;

import java.util.Arrays;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String A="babad";
        System.out.print(solve(A));
    }
    private static String solve(String A) {
        int N=A.length();
        int[][] dp=new int[N][N];
        Arrays.stream(dp).forEach(row->Arrays.fill(row,1));
        int maxLen=1;
        int l=N-1;
        int r=N-1;

        for(int j=1;j<N;j++){
            for(int row=0,col=j;col<N;row++,col++){
                dp[row][col]=A.charAt(row)==A.charAt(col) && dp[row+1][col-1]==1 ? 1 : 0;
            }
        }

        for(int j=N-1;j>=0;j--){
            for(int i=j;i>=0;i--){
                if(dp[i][j]==1 && j-i+1>=maxLen){
                    maxLen=j-i+1;
                    l=i;
                    r=j;
                }
            }
        }
        return A.substring(l,r+1);
    }
}
