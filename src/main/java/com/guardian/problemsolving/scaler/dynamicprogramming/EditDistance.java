package com.guardian.problemsolving.scaler.dynamicprogramming;

public class EditDistance {
    public static void main(String[] args) {
        String A="Anshuman";
        String B="Antihuman";
        System.out.print(minDistance(A,B));
    }
    private static int minDistance(String A, String B) {
        int[][] dp=new int[A.length()+1][B.length()+1];

        for(int i=0;i<=A.length();i++)
            dp[i][0]=i;
        for(int j=0;j<=B.length();j++)
            dp[0][j]=j;

        for(int i=1;i<=A.length();i++){
            for(int j=1;j<=B.length();j++){
                if(A.substring(i-1,i).equals(B.substring(j-1,j)))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
            }
        }
        return dp[A.length()][B.length()];
    }
}
