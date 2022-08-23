package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.*;

public class ReversingElementsOfQueue {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int B=3;
        solve(A,B).forEach(e->System.out.print(e+" "));
    }
    private static ArrayList<Integer> solve(ArrayList<Integer> A, int B){
        int N=A.size();
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> Q=new LinkedList<>();
        Stack<Integer> S=new Stack<>();

        for(int i=0;i<N;i++)
            Q.add(A.get(i));

        for(int i=0;i<B;i++){
            S.push(Q.peek());
            Q.remove();
        }

        while(!S.empty()){
            Q.add(S.peek());
            S.pop();
        }

        for(int i=0;i<N-B;i++){
            Q.add(Q.peek());
            Q.remove();
        }

        for(int i=0;i<N;i++){
            ans.add(Q.peek());
            Q.remove();
        }
        return ans;
    }
}
