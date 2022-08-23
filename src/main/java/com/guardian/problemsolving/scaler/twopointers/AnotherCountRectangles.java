package com.guardian.problemsolving.scaler.twopointers;

public class AnotherCountRectangles {
    public static void main(String[] args) {
        int[] A={1, 2};
        int B=5;
        System.out.print(solve(A,B));
    }
    public static int solve(int[] A, int B){
        long mod=(long)1e9+7;
        int N=A.length;
        long count=0;
        int l=0; int r=N-1;

        while(l<=r){
            double n1=A[l];
            double n2=A[r];
            if(n1<B/n2){
                count=(count%mod+((2*(r-l+1))-1)%mod)%mod;
                l++;
            }
            else
                r--;
        }
        count%=mod;
        while(count<0) {
            count+=mod;
        }
        count%=mod;
        return (int)count;
    }
}
