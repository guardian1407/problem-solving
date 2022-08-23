package com.guardian.problemsolving.scaler.arrays;

public class MinimumPicks {
    public static void main(String[] args) {
        int[] A = {6, 2, 2, 9};
        System.out.print(solve(A));
    }
    static int solve(int[] A) {
        Integer maxEven=null;
        Integer minOdd=null;

        for(int i=0; i<A.length; i++) {
            if(A[i]%2==0 && (maxEven==null || A[i]>maxEven))
                maxEven=A[i];
            else if (A[i]%2!=0 && (minOdd==null || A[i]<minOdd))
                minOdd=A[i];
        }
        if(maxEven==null)
            maxEven=0;
        if(minOdd==null)
            minOdd=0;
        return maxEven-minOdd;
    }
}
