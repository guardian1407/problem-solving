package com.guardian.problemsolving.scaler.twopointers;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] A={4, 7, 9};
        int[] B={2 ,11, 19};

        Arrays.stream(solve(A,B)).forEach(e->System.out.print(e+" "));
    }
    private static int[] solve(final int[] A, final int[] B){
        int[] ans=new int[A.length+B.length];
        int i=0;
        int j=0;
        int k=0;

        while(i<A.length && j<B.length){
            if(A[i]<B[j])
                ans[k++]=A[i++];
            else
                ans[k++]=B[j++];
        }

        while(i<A.length)
            ans[k++]=A[i++];

        while(j<B.length)
            ans[k++]=B[j++];

        return ans;
    }
    private static int[] solve1(final int[] A, final int[] B){
        int N1=A.length;
        int N2=B.length;
        int[] C=new int[N1+N2];
        int i=0; int j=0; int k=0;

        while(i<N1 && j<N2){
            if(A[i]<=B[j])
                C[k++]=A[i++];
            else
                C[k++]=B[j++];
        }
        if(i<N1){
            while(i<N1)
                C[k++]=A[i++];
        }
        else{
            while(j<N2)
                C[k++]=B[j++];
        }
        return C;
    }
}
