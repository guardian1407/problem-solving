package com.guardian.problemsolving.scaler.arrays;

public class PairSumDivisibleByM {
    public static void main(String[] args) {
        int[] A={1, 2, 3, 4, 5};
        int B=2;
        System.out.print(solve(A,B));
    }
    private static int solve(int[] A, int B) {
        long mod=(long)1e9+7;
        int N=A.length;
        long ans=0;
        long[] freq=new long[B];
        int l=1,r=B-1;

        for(int i=0;i<N;i++)
            freq[A[i]%B]=freq[A[i]%B]+1;

        while(l<r){
            ans+=(freq[l]%mod*freq[r]%mod)%mod;
            l++;r--;
        }
        ans+=(freq[0]*(freq[0]-1))/2;

        if(B%2==0)
            ans+=(freq[B/2]*(freq[B/2]-1))/2;

        return (int)(ans%mod);
    }
}
