package com.guardian.problemsolving.scaler.arrays;

import java.util.Arrays;

public class InversionCountInAnArray {
    private static long mod=(long)1e9+7;
    public static void main(String[] args) {
        int[] A={3, 2, 1};
        System.out.print(solve(A));
    }
    private static int solve(int[] A) {
        return (int)mergeSortCount(A,0,A.length-1);
    }
    private static long mergeSortCount(int[]A,int l,int r){
        long count=0;
        if(l<r){
            int mid=l+((r-l)/2);
            count+=mergeSortCount(A,l,mid)%mod;
            count+=mergeSortCount(A,mid+1,r)%mod;
            count+=mergeCount(A,l,mid,r)%mod;
        }

        count%=mod;
        while(count<0)
            count+=mod;
        count%=mod;
        return count;
    }
    private static long mergeCount(int[]A,int l,int mid,int r){
        int count=0;
        int i=0,j=0,k=l;
        int[] left=Arrays.copyOfRange(A,l,mid+1);
        int[] right=Arrays.copyOfRange(A,mid+1,r+1);

        while(i<left.length && j<right.length){
            if(left[i]<=right[j])
                A[k++]=left[i++];
            else{
                A[k++]=right[j++];
                count+=(mid%mod+1%mod-l%mod-i%mod)%mod;
            }
        }
        while(i<left.length)
            A[k++]=left[i++];
        while(j<right.length)
            A[k++]=right[j++];

        count%=mod;
        while(count<0)
            count+=mod;
        count%=mod;
        return count;
    }
}
