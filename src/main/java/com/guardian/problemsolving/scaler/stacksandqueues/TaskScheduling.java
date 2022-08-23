package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.LinkedList;
import java.util.Queue;

public class TaskScheduling {
    public static void main(String[] args) {
        int[] A={2, 3, 1, 5, 4};
        int[] B={1, 3, 5, 4, 2};
        System.out.print(solve(A,B));
    }
    private static int solve(int[] A, int[] B) {
        Queue<Integer> queue=new LinkedList<>();
        int time=0;
        int j=0;

        for(int i=0;i<A.length;i++){
            if(A[i]==B[j])
                j++;
            else
                queue.add(A[i]);
            time++;
        }
        while(j<B.length){
            int front=queue.poll();
            if(B[j]==front)
                j++;
            else
                queue.add(front);
            time++;
        }
        return time;
    }
}
