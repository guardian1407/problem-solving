package com.guardian.problemsolving.scaler.arrays;

public class MinimumSwaps2 {
    public static void main(String[] args) {
        int[] A={1, 2, 3, 4, 0};
        System.out.print(solve(A));
    }
    private static int solve(int[] A){
        int N=A.length;
        int i =0;
        int count=0;

        while(i<N){
            if(A[i]!=i){
                int temp=A[i];
                A[i]=A[temp];
                A[temp]=temp;
                count++;
            }
            else
                i++;
        }
        return count;
    }
}
