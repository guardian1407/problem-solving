package com.guardian.problemsolving.scaler.math;

public class ABandModulo {
    public static void main(String[] args) {
        int A=120269;
        int B=56254;
        System.out.print(solve(A,B));
    }
    private static int solve(int A, int B) {
        return Math.abs(A-B);
    }
}
