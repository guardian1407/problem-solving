package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.Stack;

public class AllSubarrays {
    public static void main(String[] args) {
        int[] A={2, 3, 1, 4};
        System.out.print(solve(A));
    }
    private static int solve(int[] A) {
        int ans=Integer.MIN_VALUE;
        Stack<Integer> stackRight=new Stack<>();
        Stack<Integer> stackLeft=new Stack<>();

        for(int i=0;i<A.length;i++){
            while(!stackLeft.isEmpty()){
                ans=Math.max(ans,stackLeft.peek()^A[i]);
                if(stackLeft.peek()<=A[i])
                    stackLeft.pop();
                else
                    break;
            }
            stackLeft.push(A[i]);
        }

        for(int i=A.length-1;i>=0;i--){
            while(!stackRight.isEmpty()){
                ans=Math.max(ans,stackRight.peek()^A[i]);
                if(stackRight.peek()<=A[i])
                    stackRight.pop();
                else
                    break;
            }
            stackRight.push(A[i]);
        }
        return ans;
    }
}
