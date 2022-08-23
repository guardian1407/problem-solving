package com.guardian.problemsolving.scaler.math;

public class StringPartitions {
    public static void main(String[] args) {
        int A=120269;
        int B=56254;
        int C=5599;
        int D=11585;
        System.out.print(solve(A,B,C,D));
    }
    private static long solve(int A, int B, int C, int D){
        long l=(long)Math.pow(A-(B+C+D)+1,2);
        long n=A-(B+C+D);
        long r=(n*(n+1))/2;
        long count=l-r;
        return count%1000000007;
    }
}
