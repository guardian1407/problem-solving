package com.guardian.problemsolving.scaler.arrays;

public class EquilibriumIndex {
    public static void main(String[] args) {
        int[] A={-7, 1, 5, 2, -4, 3, 0};
        System.out.print(solve(A));
    }
    static int solve(int[] A) {
        int rSum=0;
        int lSum=0;

        for(int i=0;i<A.length;i++)
            rSum+=A[i];

        for(int i=0;i<A.length;i++){
            rSum-=A[i];
            if(lSum==rSum) return i;
            lSum+=A[i];
        }
        return -1;
    }
}
