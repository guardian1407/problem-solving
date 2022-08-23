package com.guardian.problemsolving.scaler.recursion;

public class FindFibonacci {
    public static void main(String[] args) {
        int A=9;
        System.out.print(findAthFibonacci(A));
    }
    static int findAthFibonacci(int A) {
        if(A==0)
            return 0;
        else if(A==1)
            return 1;
        else
            return findAthFibonacci(A-1)+findAthFibonacci(A-2);
    }
}
