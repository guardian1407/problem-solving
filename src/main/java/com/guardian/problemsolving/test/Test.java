package com.guardian.problemsolving.test;

public class Test {
    public static void main(String[] args) {
        int row=3,col=3;
        System.out.print(solve(row,col));
    }
    private static int solve(int row, int col){
        int dp[][]=new int[row][col];
        for(int i=0;i<row;i++)
            dp[i][0]=1;
        for(int j=0;j<col;j++)
            dp[0][j]=1;
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[row-1][col-1];
    }
    private static int solve2(int[][] A, int row, int col){
        int dp[][]=new int[row][col];
        for(int i=0;i<row;i++){
            if(A[i][0]!=1)
                dp[i][0]=1;
        }
        for(int j=0;j<col;j++){
            if(A[0][j]!=1)
                dp[0][j]=1;
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(A[i][j]!=1){
                    dp[i][j]=dp[i][j-1]+dp[i-1][j];
                }
            }
        }
        return dp[row-1][col-1];
    }
}
