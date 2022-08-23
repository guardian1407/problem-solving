package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args) {
        String A="{([])}";
        System.out.print(solve(A));
    }
    private static int solve(String A){
        Stack<Character> S=new Stack<>();

        for(int i=0;i<A.length();i++){
            char C=A.charAt(i);

            if(C=='{' || C=='(' || C=='[')
                S.push(C);
            else{
                if(S.isEmpty())
                    return 0;
                char T=S.peek();

                if((C=='}' && T=='{') || (C==')' && T=='(') || (C==']' && T=='['))
                    S.pop();
                else
                    return 0;
            }
        }
        return S.isEmpty() ? 1 : 0;
    }
}
