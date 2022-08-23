package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumbers {
    public static void main(String[] args) {
        int A=5;
        System.out.print(solve(A));
    }
    private static String solve(int A){
        if(A==1)
            return "11";
        else if(A==2)
            return "22";
        else{
            Queue<String> Q=new LinkedList<>();
            Q.add("1");
            Q.add("2");
            String ans="";

            for(int i=3;i<=A;i++){
                if(i%2==1)
                    ans=Q.peek()+"1";
                else{
                    ans=Q.peek()+"2";
                    Q.remove();
                }
                Q.add(ans);
            }

            int N=ans.length();
            StringBuffer sb=new StringBuffer(ans);
            for(int i=N-1;i>=0;i--)
                sb.append(ans.charAt(i));

            return sb.toString();
        }
    }
}
