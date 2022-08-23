package com.guardian.problemsolving.scaler.arrays;

import java.util.Arrays;

public class SumTheDifference {
    public static void main(String[] args) {
        int[] A={1, 2};
        System.out.print(solve(A));
    }
    private static int solve(int[] A) {
        long mod=(long)1e9+7;
        long ans=0;
        Arrays.sort(A);

        for(int i=0;i<A.length;i++)
            ans+=(A[i]%mod*((Math.pow(2,i)%mod-Math.pow(2,A.length-i-1)%mod)%mod))%mod;

        ans%=mod;
        while(ans<0)
            ans+=mod;
        ans%=mod;
        return (int)ans;
    }
}
