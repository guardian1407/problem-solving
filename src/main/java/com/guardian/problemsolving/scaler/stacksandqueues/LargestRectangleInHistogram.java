package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2, 3));
        System.out.print(largestRectangleArea(A));
    }
    private static int largestRectangleArea(ArrayList<Integer> A){
        int N=A.size();
        ArrayList<Integer> NSELeft=new ArrayList<>();
        ArrayList<Integer> NSERight=new ArrayList<>();
        Stack<Integer> SE=new Stack<>();

        for(int i=0;i<N;i++){
            int E=A.get(i);

            int NSE=-1;
            if(!SE.isEmpty()){
                if(A.get(SE.peek())<E)
                    NSE=SE.peek();
                else{
                    while(!SE.isEmpty() && A.get(SE.peek())>=E)
                        SE.pop();
                    NSE=!SE.isEmpty() ? SE.peek() : -1;
                }
            }
            NSELeft.add(NSE);
            SE.push(i);
        }

        SE=new Stack<>();
        Stack<Integer> SET=new Stack<>();

        for(int i=N-1;i>=0;i--){
            int E=A.get(i);

            int NSE=-1;
            if(!SE.isEmpty()){
                if(A.get(SE.peek())<E)
                    NSE=SE.peek();
                else{
                    while(!SE.isEmpty() && A.get(SE.peek())>=E)
                        SE.pop();
                    NSE=!SE.isEmpty() ? SE.peek() : -1;
                }
            }
            SET.push(NSE);
            SE.push(i);
        }

        while(!SET.isEmpty())
            NSERight.add(SET.pop());

        int maxArea=0;

        for(int i=0;i<N;i++){
            int l=NSELeft.get(i)+1;
            int r=NSERight.get(i)==-1 ? N-1 : NSERight.get(i)-1;
            int area=(r-l+1)*A.get(i);
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
}
