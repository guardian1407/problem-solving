package com.guardian.problemsolving.scaler.dynamicprogramming;

public class UniquePathsInAGrid {
    public static void main(String[] args) {
        int[][] A={{0, 0, 0},{0, 1, 0},{0, 0, 0}};
        System.out.print(uniquePathsWithObstacles(A));
    }
    private static int uniquePathsWithObstacles(int[][] A) {
        int N=A.length;
        int M=A[0].length;
        if(A[0][0]==1 || A[N-1][M-1]==1)
            return 0;

        A[N-1][M-1]=1;
        for(int i=N-2;i>=0;i--)
            A[i][M-1]=A[i][M-1]==0 ? A[i+1][M-1] : 0;

        for(int j=M-2;j>=0;j--)
            A[N-1][j]=A[N-1][j]==0 ? A[N-1][j+1] : 0;

        for(int i=N-2;i>=0;i--)
            for(int j=M-2;j>=0;j--)
                A[i][j]=A[i][j]==0 ? A[i][j+1]+A[i+1][j] : 0;

        return A[0][0];
    }
}
