package com.guardian.problemsolving.scaler.binarysearch;

public class SpecialInteger {
    public static void main(String[] args){
        int[] A={5, 17, 100, 11};
        int B=130;
        System.out.print(solve(A,B));
    }
    private static int solve(int[] A, int B){
        int N=A.length;
        int l=1; int r=N;
        int ans=0;
        long[] P=new long[N];
        P[0]=A[0];

        for(int i=1;i<N;i++)
            P[i]=P[i-1]+A[i];

        //feasibility check for each value and discarding one half
        while(l<=r){
            int mid=l+((r-l)/2);

            if(checkFeasibility(P,B,mid)){
                ans=mid;
                l=mid+1;
            }
            else
                r=mid-1;
        }
        return ans;
    }

    //function to check feasibility for sum of each subarray of size K
    private static boolean checkFeasibility(long[] P, int B, int K){
        int N=P.length;
        int l=0; int r=K-1;

        if(P[r]>B)
            return false;

        while(++r<N){
            if(P[r]-P[l++]>B)
                return false;
        }
        return true;
    }
}
