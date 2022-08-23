package com.guardian.problemsolving.scaler.arrays;

public class CountWaysToMakeSumOfOddAndEvenElements {
    public static void main(String[] args) {
        int[] A={2, 1, 6, 4};
        System.out.print(solve(A));
    }
    static int solve(int[] A) {
        int rOdd=0; int rEven=0;
        int lOdd=0; int lEven=0;
        int count=0;

        for(int i=0;i<A.length;i++){
            if(i%2==0) rEven+=A[i];
            else rOdd+=A[i];
        }

        for(int i=0;i<A.length;i++){
            if(i%2==0) rEven-=A[i];
            else rOdd-=A[i];

            if(lOdd+rEven == lEven+rOdd) count++;

            if(i%2==0) lEven+=A[i];
            else lOdd+=A[i];
        }
        return count;
    }
}
