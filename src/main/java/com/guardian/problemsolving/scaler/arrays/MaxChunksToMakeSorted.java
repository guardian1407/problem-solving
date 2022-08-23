package com.guardian.problemsolving.scaler.arrays;

public class MaxChunksToMakeSorted {
    public static void main(String[] args) {
        int[] A={1, 2, 3, 4, 0};
        System.out.print(solve(A));
    }
    private static int solve(int[] A) {
        int N=A.length;
        int count=0;
        int max=0;

        for(int i=0;i<N;i++){
            max=Math.max(max,A[i]);
            if(max==i)
                count++;
        }
        return count;
    }
}
