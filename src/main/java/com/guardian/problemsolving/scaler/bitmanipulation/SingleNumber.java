package com.guardian.problemsolving.scaler.bitmanipulation;

public class SingleNumber {
    public static void main(String[] args) {
        int[] A={4,4,5,5,6};
        System.out.print(singleNumber(A));
    }
    static int singleNumber(final int[] A) {
        int a = 0;
        for (int i : A) {
            a ^= i;
        }
        return a;
    }
}
