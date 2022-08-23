package com.guardian.problemsolving.scaler.dynamicprogramming;

public class DungeonPrincess {
    public static void main(String[] args) {
        int[][] A={{-2, -3, 3},{-5, -10, 1},{10, 30, -5}};
        System.out.print(calculateMinimumHP(A));
    }
    private static int calculateMinimumHP(int[][] A) {
        int N=A.length;
        int M=A[0].length;

        A[N-1][M-1]=Math.max(1,1-A[N-1][M-1]);
        for(int i=N-2;i>=0;i--)
            A[i][M-1]=Math.max(1,A[i+1][M-1]-A[i][M-1]);

        for(int j=M-2;j>=0;j--)
            A[N-1][j]=Math.max(1,A[N-1][j+1]-A[N-1][j]);

        for(int i=N-2;i>=0;i--)
            for(int j=M-2;j>=0;j--)
                A[i][j]=Math.max(1,Math.min(A[i][j+1],A[i+1][j])-A[i][j]);

        return A[0][0];
    }
}
