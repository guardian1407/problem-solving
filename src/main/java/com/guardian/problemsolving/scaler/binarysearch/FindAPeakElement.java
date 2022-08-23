package com.guardian.problemsolving.scaler.binarysearch;

public class FindAPeakElement {
    public static void main(String[] args) {
        int[] A = {5, 17, 100, 11};
        System.out.println(solve(A));
    }
    private static int solve(int[] A){
        int N=A.length;
        if(N==1)
            return A[0];
        int l=0; int r=N-1;
        int mid=l+((r-l)/2);

        while(l<=r){
            mid=l+((r-l)/2);

            if((mid==0 && A[mid]>=A[mid+1]) || (mid==N-1 && A[mid]>=A[mid-1])
                    || (mid>0 && mid<N-1 && A[mid]>=A[mid+1] && A[mid]>=A[mid-1]))
                break;

            if(mid==0 || A[mid-1]<A[mid])
                l=mid+1;
            else if(mid==N-1 || A[mid]>A[mid+1])
                r=mid-1;
        }
        return A[mid];
    }
}
