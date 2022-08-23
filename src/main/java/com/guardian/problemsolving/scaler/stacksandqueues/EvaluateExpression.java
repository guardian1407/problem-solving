package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) {
        String[] A={"4", "13", "5", "/", "+"};
        System.out.print(evalRPN(A));
    }
    private static int evalRPN(String[] A) {
        Stack<String> stack=new Stack<>();

        for(int i=0;i<A.length;i++){
            String s=A[i];
            if("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)){
                int second=Integer.parseInt(stack.pop());
                int first=Integer.parseInt(stack.pop());
                int val;
                switch(s){
                    case "+":
                        val=first+second;
                        break;
                    case "-":
                        val=first-second;
                        break;
                    case "*":
                        val=first*second;
                        break;
                    case "/":
                        val=first/second;
                        break;
                    default:
                        val=0;
                        break;
                }
                stack.push(String.valueOf(val));
            }
            else
                stack.push(s);
        }
        return Integer.parseInt(stack.pop());
    }
}
