package com.guardian.problemsolving.scaler.dynamicprogramming;

public class MinSumPathInMatrix {
    public static void main(String[] args) {
        int[][] A={{1, 3, 2},{4, 3, 1},{5, 6, 1}};
        System.out.print(minPathSum(A));
    }
    private static int minPathSum(int[][] A) {
        int N=A.length;
        int M=A[0].length;

        for(int i=1;i<N;i++)
            A[i][0]=A[i][0]+A[i-1][0];

        for(int j=1;j<M;j++)
            A[0][j]=A[0][j]+A[0][j-1];

        for(int i=1;i<N;i++)
            for(int j=1;j<M;j++)
                A[i][j]=A[i][j]+Math.min(A[i][j-1],A[i-1][j]);

        return A[N-1][M-1];
    }
}
