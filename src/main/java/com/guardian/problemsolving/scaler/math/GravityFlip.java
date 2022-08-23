package com.guardian.problemsolving.scaler.math;

import java.util.Arrays;

public class GravityFlip {
    public static void main(String[] args) {
        int[] A = {8,9,2,1};
        A = solve(A);
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]);
        }
    }

    static int[] solve(int[] A) {
        Arrays.sort(A);
        return A;
    }
}
