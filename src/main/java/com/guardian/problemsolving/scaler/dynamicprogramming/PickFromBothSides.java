package com.guardian.problemsolving.scaler.dynamicprogramming;

public class PickFromBothSides {
    public static void main(String[] args) {
        int[] A={5, -2, 3 , 1, 2};
        int B=3;
        System.out.print(solve(A,B));
    }
    static int solve(int[] A, int B) {
        int sum=0;
        int l=B-1;
        int r=A.length;

        for(int i = 0; i < B; i++)
            sum+=A[i];

        int max=sum;

        while(l>=0){
            sum=sum-A[l]+A[r-1];
            max=Math.max(max,sum);
            l--; r--;
        }
        return max;
    }
}
