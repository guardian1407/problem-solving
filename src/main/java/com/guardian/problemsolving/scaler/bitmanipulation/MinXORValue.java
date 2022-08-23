package com.guardian.problemsolving.scaler.bitmanipulation;

import java.util.Arrays;

public class MinXORValue {
    public static void main(String[] args) {
        int[] A={0, 4, 7, 9};
        System.out.print(findMinXor(A));
    }
    private static int findMinXor(int[] A) {
        Arrays.sort(A);
        int minXor=Integer.MAX_VALUE;

        for (int i=0;i<A.length-1;i++)
            minXor=Math.min(minXor,A[i]^A[i+1]);

        return minXor;
    }
}
