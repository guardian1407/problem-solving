package com.guardian.problemsolving.scaler.binarysearch;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] A={82, 61, 38, 88, 12, 7, 6, 12, 48, 8, 31, 90, 35, 5, 88, 2, 66, 19, 5, 96, 84, 95};
        int B=8;
        System.out.println(solve(A,B));
    }
    private static int solve(int[] A, int B) {
        Arrays.sort(A);
        int N=A.length;
//        int l=(A[N-1]-A[0])/B;
        int l=0;
        int r=A[N-1]-A[0];

        while(r-l>1){
            int mid=(l+r)/2;

            if(check(A,B,mid))
                l=mid;
            else
                r=mid-1;
        }
        return check(A,B,r) ? r : l;
    }
    private static boolean check(int[] A,int B,int k){
        int N=A.length;
        int l=0;

        while(B>1){
            int r=l+1;
            while(r<N && A[r]-A[l]<k)
                r++;
            if(r>=N)
                return false;
            else{
                l=r;
                B--;
            }
        }
        return true;
    }
}
