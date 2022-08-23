package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.Stack;

public class DoubleCharacterTrouble {
    public static void main(String[] args) {
        String A="abccbc";
        System.out.print(solve(A));
    }
    private static String solve(String A){
        int N=A.length();
        Stack<Character> S=new Stack<>();
        StringBuffer sb=new StringBuffer();

        for(int i=N-1;i>=0;i--){
            char C=A.charAt(i);

            if(S.isEmpty() || !S.peek().equals(C))
                S.push(C);
            else
                S.pop();
        }

        while(!S.isEmpty())
            sb.append(S.pop());

        return sb.toString();
    }
}
