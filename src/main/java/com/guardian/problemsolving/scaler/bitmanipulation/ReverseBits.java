package com.guardian.problemsolving.scaler.bitmanipulation;

public class ReverseBits {
    public static void main(String[] args) {
        int A=0;
        System.out.print(reverse(A));
    }
    private static long reverse(long a){
        long rev = 0;
        for (int i = 0; i < 32; i++, a >>= 1)
            rev = (rev << 1) | (a & 1);
        return rev;
    }
}
