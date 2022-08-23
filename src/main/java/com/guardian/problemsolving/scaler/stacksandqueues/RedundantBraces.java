package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.Stack;

public class RedundantBraces {
    public static void main(String[] args) {
        String A="(a+(a+b))";
        System.out.println(braces(A));
    }
    private static int braces(String A) {
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<A.length();i++){
            char c=A.charAt(i);
            if(c==')'){
                char top=stack.pop();
                boolean isValid=false;
                while(top!='('){
                    if(top=='+' || top=='-'|| top=='*'|| top=='/')
                        isValid=true;
                    top=stack.pop();
                }
                if(!isValid)
                    return 1;
            }
            else
                stack.push(c);
        }
        return 0;
    }
}
