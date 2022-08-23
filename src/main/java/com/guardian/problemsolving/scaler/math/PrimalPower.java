package com.guardian.problemsolving.scaler.math;

public class PrimalPower {
    public static void main(String[] args) {
        int[] A={-1,1,3,5,7,9,2};
        System.out.print(solve(A));
    }
    static int solve(int[] A) {
        int count=0;

        for(int i = 0; i < A.length; i++){
            if(isPrime(A[i]))
                count++;
        }
        return count;
    }
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
