package com.guardian.problemsolving.scaler.binarysearch;

public class SortedInsertPosition {
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 6};
        int B=6;
        System.out.println(searchInsert(A,B));
    }
    private static int searchInsert(int[] A, int B){
        int N=A.length;
        int l=0; int r=N-1;
        int mid=l+((r-l)/2);

        while(l<=r){
            mid=l+((r-l)/2);

            if(A[mid]>B)
                r=mid-1;
            else if(A[mid]<B)
                l=mid+1;
            else
                break;
        }
        return A[mid]>=B ? mid : mid+1;
    }
}
