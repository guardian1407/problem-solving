package com.guardian.problemsolving.scaler.greedyalgorithm;

public class AntsProblem {
    public static void main(String[] args) {
        int A=6;
        int[] B={0,1,2,4};
        int[] C={3,5,6};
        System.out.print(solve(A,B,C));
    }

    static int solve(int A, int[] B, int[] C) {
        int maxB = B.length==0 ? 0 : B[0];
        int minC = C.length==0 ? A : C[0];

        for(int i=1; B.length>1 && i<B.length; i++){
            maxB = Math.max(maxB, B[i]);
        }
        for(int j=1; C.length>1 && j<C.length; j++){
            minC = Math.min(minC, C[j]);
        }
        return Math.max(maxB,A-minC);
    }
}
