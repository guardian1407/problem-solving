package com.guardian.problemsolving.scaler.bitmanipulation;

public class NumberOfSetBits {
    public static void main(String[] args) {
        int A=11;
        System.out.print(numSetBits(A));
    }
    private static int numSetBits(int A){
        int count=0;
        while(A>0){
            count++;
            A&=A-1;
        }
        return count;
    }
}
