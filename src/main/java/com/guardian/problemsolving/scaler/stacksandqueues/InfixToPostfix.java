package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        String A="a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(solve(A));
    }
    private static String solve(String A){
        StringBuilder res=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<A.length();i++){
            char c=A.charAt(i);
            if(Character.isLetterOrDigit(c))
                res.append(c);
            else if(c=='(')
                stack.push(c);
            else if(c==')'){
                while (!stack.isEmpty() && stack.peek()!='(')
                    res.append(stack.pop());
                stack.pop();
            }
            else{
                while(!stack.isEmpty() && getPrecedence(c)<=getPrecedence(stack.peek())){
                    res.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek()=='(')
                return "Invalid Expression";
            res.append(stack.pop());
        }
        return res.toString();
    }
    private static int getPrecedence(char C){
        switch(C){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}
