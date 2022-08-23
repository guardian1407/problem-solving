package com.guardian.problemsolving.scaler.arrays;

public class FindDeterminant {
    public static void main(String[] args) {
        int[][] A={{6, 1, 1},{4, -2, 5},{2, 8, 7}};
        System.out.print(solve(A));
    }
    public static int solve(final int[][] A) {
        if(A.length==2)
            return A[0][0]*A[1][1]-A[0][1]*A[1][0];
        else
            return A[0][0]*(A[1][1]*A[2][2]-A[1][2]*A[2][1])
                    -A[0][1]*(A[1][0]*A[2][2]-A[1][2]*A[2][0])
                    +A[0][2]*(A[1][0]*A[2][1]-A[1][1]*A[2][0]);
    }
}
