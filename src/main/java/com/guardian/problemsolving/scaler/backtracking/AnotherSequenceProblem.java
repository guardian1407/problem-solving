package com.guardian.problemsolving.scaler.backtracking;

public class AnotherSequenceProblem {
    public static void main(String[] args) {
        int A=3;
        System.out.print(solve(A));
    }
    private static int solve(int A){
        if(A==0 || A==1)
            return 1;
        else if(A==2)
            return 2;
        else
            return A+solve(A-1)+solve(A-2)+solve(A-3);
    }
}
