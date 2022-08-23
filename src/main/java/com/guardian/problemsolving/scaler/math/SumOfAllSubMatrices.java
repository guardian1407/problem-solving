package com.guardian.problemsolving.scaler.math;

public class SumOfAllSubMatrices {
    public static void main(String[] args){
        int[][] A={{1, 1}, {1, 1}};
        System.out.print(solve(A));
    }
    private static int solve(int[][] A){
        int N=A.length;
        int sum=0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sum+=(i+1)*(j+1)*(N-i)*(N-j)*A[i][j];
            }
        }
        return sum;
    }
}
