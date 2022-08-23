package com.guardian.problemsolving.scaler.binarysearch;

import java.util.Arrays;

public class KthSmallest {
    public static void main(String[] args) {
        int[] A={-1,1,3,5,7,9,2};
        int B=3;
        System.out.print(kthsmallest(A,B));
    }
    static int kthsmallest(final int[] A, int B){
        Arrays.sort(A);
        return A[B-1];
    }
}
