package com.guardian.problemsolving.scaler.arrays;

import java.util.Arrays;

public class ReversePairs {
    public static void main(String[] args) {
        int[] A={1, 3, 2, 3, 1};
        System.out.print(solve(A));
    }
    private static int solve(int[] A) {
        return mergeSortCount(A,0,A.length-1);
    }
    private static int mergeSortCount(int[]A,int l,int r){
        int count=0;
        if(l<r){
            int mid=l+((r-l)/2);
            count+=mergeSortCount(A,l,mid)+mergeSortCount(A,mid+1,r);
            for(int i=l;i<=mid;i++){
                int j=mid+1;
                while(j<=r && A[i]/2.0>A[j]) //division by 2.0 instead of multiplication to avoid overflow
                    j++;
                count+=j-(mid+1);
            }
            merge(A,l,mid,r);
        }
        return count;
    }
    private static void merge(int[]A,int l,int mid,int r){
        int i=0,j=0,k=l;
        int[] left=Arrays.copyOfRange(A,l,mid+1);
        int[] right=Arrays.copyOfRange(A,mid+1,r+1);

        while(i<left.length && j<right.length){
            if(left[i]<=right[j])
                A[k++]=left[i++];
            else
                A[k++]=right[j++];
        }
        while(i<left.length)
            A[k++]=left[i++];
        while(j<right.length)
            A[k++]=right[j++];
    }
}
