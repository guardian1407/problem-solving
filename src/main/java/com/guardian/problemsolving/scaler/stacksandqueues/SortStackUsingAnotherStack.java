package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SortStackUsingAnotherStack {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(5, 17, 100, 11));
        solve(A).forEach(e->System.out.print(e+" "));
    }
    private static ArrayList<Integer> solve(ArrayList<Integer> A){
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<Integer> S=new Stack<>();
        Stack<Integer> T=new Stack<>();

        for(int i=0;i<A.size();i++){
            int E=A.get(i);

            if(S.isEmpty() || S.peek()>=E)
                S.push(E);
            else{
                while(!S.isEmpty() && S.peek()<E)
                    T.push(S.pop());
                S.push(E);
                while(!T.isEmpty())
                    S.push(T.pop());
            }
        }
        while(!S.isEmpty())
            ans.add(S.pop());
        return ans;
    }
}
