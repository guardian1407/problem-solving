package com.guardian.problemsolving.scaler.math;

public class SquareGranites {
    public static void main(String[] args) {
        System.out.println(solve(6,6,4));
    }
    static int solve(int A, int B, int C) {
        int a = (int)Math.ceil((double)A/C);
        int b = (int)Math.ceil((double)B/C);
        return a*b;
    }
}
