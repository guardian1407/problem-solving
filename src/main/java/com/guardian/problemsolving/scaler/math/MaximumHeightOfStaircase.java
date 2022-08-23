package com.guardian.problemsolving.scaler.math;

public class MaximumHeightOfStaircase {
    public static void main(String[] args) {
        int A=10;
        System.out.print(solve(A));
    }
    private static int solve(int A) {
        if(A==0) return 0;
        int i=1;
        while(A>=i){
            A-=i;
            i++;
        }
        return i-1;
    }
}
