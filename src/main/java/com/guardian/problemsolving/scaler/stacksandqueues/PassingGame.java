package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class PassingGame {
    public static void main(String[] args) {
        int A=10;
        int B=23;
        ArrayList<Integer> C=new ArrayList<>(Arrays.asList(86, 63, 60, 0, 47, 0, 99, 9, 0, 0));
        System.out.print(solve(A,B,C));
    }
    private static int solve(int A, int B, ArrayList<Integer> C){
        Stack<Integer> S=new Stack<>();
        S.push(B);

        for(int i=0;i<A;i++){
            int E=C.get(i);

            if(E>0)
                S.push(E);
            else
                S.pop();
        }
        return S.peek();
    }
}
