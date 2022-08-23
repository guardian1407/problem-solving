package com.guardian.problemsolving.scaler.math;

public class DivisorGame {
    public static void main(String[] args){
        int A=12; int B=3; int C=2;
        System.out.print(solve(A,B,C));
    }
    private static int solve(int A, int B, int C){
        int lcm=(B*C)/gcd(B,C);
        return A/lcm;
    }
    private static int gcd(int A,int B){
        if(B==0)
            return A;
        return gcd(B,A%B);
    }
}
