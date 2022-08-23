package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NextGreater {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(4, 5, 2, 10));
        nextGreater(A).forEach(e->System.out.print(e+" "));
    }
    private static ArrayList<Integer> nextGreater(ArrayList<Integer> A){
        int N=A.size();
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<Integer> T=new Stack<>();
        Stack<Integer> S=new Stack<>();

        for(int i=N-1;i>=0;i--){
            int E=A.get(i);
            int NGE=-1;

            if(!S.isEmpty()){
                if(S.peek()>E)
                    NGE=S.peek();
                else{
                    while(!S.isEmpty() && S.peek()<=E)
                        S.pop();
                    NGE=!S.isEmpty() ? S.peek() : -1;
                }
            }
            T.push(NGE);
            S.push(E);
        }

        while(!T.isEmpty())
            ans.add(T.pop());

        return ans;
    }
}
