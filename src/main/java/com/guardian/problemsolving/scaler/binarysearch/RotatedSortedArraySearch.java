package com.guardian.problemsolving.scaler.binarysearch;

public class RotatedSortedArraySearch {
    public static void main(String[] args) {
        int[] A = {4, 5, 6, 7, 0, 1, 2, 3};
        int B=8;
        System.out.println(search(A,B));
    }
    private static int search(final int[] A, int B){
        int N=A.length;
        int l=0; int r=N-1;

        if(B>=A[0]){
            while(l<=r){
                int mid=l+((r-l)/2);

                if(A[mid]<A[0])
                    r=mid-1;
                else if(A[mid]<B)
                    l=mid+1;
                else if(A[mid]>B)
                    r=mid-1;
                else
                    return mid;
            }
        }
        else{
            while(l<=r){
                int mid=l+((r-l)/2);

                if(A[mid]>=A[0])
                    l=mid+1;
                else if(A[mid]<B)
                    l=mid+1;
                else if(A[mid]>B)
                    r=mid-1;
                else
                    return mid;
            }
        }
        return -1;
    }
}
