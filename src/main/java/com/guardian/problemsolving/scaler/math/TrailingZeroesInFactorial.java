package com.guardian.problemsolving.scaler.math;

public class TrailingZeroesInFactorial {
    public static void main(String[] args) {
        int A=26;
        System.out.print(trailingZeroes(A));
    }
    private static int trailingZeroes(int A) {
        int count=0;
        while(A>0){
            count+=A/5;
            A/=5;
        }
        return count;
    }
}
