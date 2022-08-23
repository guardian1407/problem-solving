package com.guardian.problemsolving.scaler.dynamicprogramming;

public class RegularExpressionII {
    public static void main(String[] args) {
        String A="aab";
        String B="c*a*b";
        System.out.print(isMatch(A,B));
    }
    private static int isMatch(final String A, final String B) {
        int[][] dp=new int[2][B.length()+1];
        dp[0][0]=1;
        dp[1][0]=0;

        for(int j=1;j<=B.length();j++)
            if("*".equals(B.substring(j-1,j)))
                dp[0][j]=dp[0][j-1];
            else
                dp[0][j]=0;

        for(int i=1;i<=A.length();i++){
            for(int j=1;j<=B.length();j++){
                if("?".equals(B.substring(j-1,j)))
                    dp[1][j]=dp[0][j-1];
                else if("*".equals(B.substring(j-1,j))){
                    dp[1][j]=dp[1][j-1]==1 || dp[0][j]==1 ? 1 : 0;
                }
                else{
                    if(A.substring(i-1,i).equals(B.substring(j-1,j)))
                        dp[1][j]=dp[0][j-1];
                    else
                        dp[1][j]=0;
                }
            }
            copyCurrentRow(dp);
        }
        return dp[1][B.length()];
    }
    private static void copyCurrentRow(int[][] dp){
        if(dp[0].length>=1)
            System.arraycopy(dp[1],0,dp[0],0,dp[0].length);
    }
}
