package com.guardian.problemsolving.scaler.recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        int A=8888;
        System.out.print(solve(A));
    }
    private static int solve(int A) {
        if(A==0)
            return 0;
        return solve(A/10)+A%10;
    }
}
