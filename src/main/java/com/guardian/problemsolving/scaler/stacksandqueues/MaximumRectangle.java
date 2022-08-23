package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.Stack;

public class MaximumRectangle {
    public static void main(String[] args) {
        int[][] A={{0, 0, 1},{0, 1, 1},{1, 1, 1}};
        System.out.println(solve(A));
    }
    public static int solve(int[][] A) {
        if (A==null||A.length==0||A[0].length==0)
            return 0;
        int cLen = A[0].length;    // column length
        int rLen = A.length;       // row length
        // height array
        int[] h = new int[cLen+1];
        h[cLen]=0;
        int max = 0;


        for (int row=0;row<rLen;row++) {
            Stack<Integer> s = new Stack<>();
            for (int i=0;i<cLen+1;i++) {
                if (i<cLen)
                    if(A[row][i]==1)
                        h[i]+=1;
                    else h[i]=0;

                if (s.isEmpty()||h[s.peek()]<=h[i])
                    s.push(i);
                else {
                    while(!s.isEmpty()&&h[i]<h[s.peek()]){
                        int top = s.pop();
                        int area = h[top]*(s.isEmpty()?i:(i-s.peek()-1));
                        if (area>max)
                            max = area;
                    }
                    s.push(i);
                }
            }
        }
        return max;
    }
}
