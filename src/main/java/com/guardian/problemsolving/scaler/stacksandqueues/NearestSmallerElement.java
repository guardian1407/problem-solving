package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(4, 5, 2, 10, 8));
        prevSmaller(A).forEach(e->System.out.print(e+" "));
    }
    private static ArrayList<Integer> prevSmaller(ArrayList<Integer> A){
        int N=A.size();
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<Integer> S=new Stack<>();

        for(int i=0;i<N;i++){
            int E=A.get(i);
            int NSE=-1;

            if(!S.isEmpty()){
                if(S.peek()<E)
                    NSE=S.peek();
                else{
                    while(!S.isEmpty() && S.peek()>=E)
                        S.pop();
                    NSE=!S.isEmpty() ? S.peek() : -1;
                }
            }
            ans.add(NSE);
            S.push(E);
        }
        return ans;
    }
}
