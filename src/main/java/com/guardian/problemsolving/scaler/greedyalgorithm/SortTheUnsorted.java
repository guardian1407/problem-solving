package com.guardian.problemsolving.scaler.greedyalgorithm;

import java.util.Arrays;

public class SortTheUnsorted {
    public static void main(String[] args) {
        int[] A={0, 1, 15, 25, 6, 7, 30, 40, 50};
        System.out.print(solve(A));
    }
    static int solve(int[] A) {
        int l=0; int r=A.length-1;
        int[] B=new int[A.length];

        for(int i=0;i<A.length;i++)
            B[i]=A[i];
        Arrays.sort(B);

        while(l<A.length){
            if(A[l]!=B[l]) break;
            l++;
        }
        while(r>=0){
            if(A[r]!=B[r]) break;
            r--;
        }
        return r<=l ? 0 : r-l+1;
    }
}
