package com.guardian.problemsolving.scaler.math;

import java.util.Arrays;

public class MinimumDifferencePuzzle {
    public static void main(String[] args) {
        int[] A={10, 12, 10, 7, 5, 22};
        int B=4;
        System.out.print(solve(A,B));
    }
    static int solve(int[] A, int B) {
        Arrays.sort(A);
        int l=0; int r=B-1;
        int minDiff=Integer.MAX_VALUE;

        while(r<A.length){
            minDiff=Math.min(minDiff,A[r]-A[l]);
            l++; r++;
        }
        return minDiff;
    }
}
