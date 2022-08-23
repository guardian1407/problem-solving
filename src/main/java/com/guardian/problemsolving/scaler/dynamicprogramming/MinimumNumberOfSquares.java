package com.guardian.problemsolving.scaler.dynamicprogramming;

import java.util.Arrays;

public class MinimumNumberOfSquares {
    public static void main(String[] args) {
        int A=12;
        System.out.print(countMinSquares(A));
    }
    private static int countMinSquares(int A) {
        int[] dp=new int[A+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=1;i<=A;i++){
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[A];
    }

    //TLE;heap space error
    private static int countMinSquares(int A,int[] dp){
        if(A==0)
            return 0;
        else if(A==1)
            return 1;
        else{
            if(dp[A]==0){
                int min=A;
                for(int i=1;i*i<=A;i++)
                    min=Math.min(min,countMinSquares(A-i*i));
                dp[A]=min+1;
            }
            return dp[A];
        }
    }
}
