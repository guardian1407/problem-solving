package com.guardian.problemsolving.scaler.greedyalgorithm;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class TheShipCompany {
    public static void main(String[] args) {
        int A=4;
        int B=3;
        int[] C={2, 2, 2};
        Arrays.stream(solve(A,B,C)).forEach(e->System.out.print(e+" "));
    }
    private static int[] solve(int A, int B, int[] C) {
        int[] ans=new int[2];
        int cost=0;
        Queue<Integer> pQueue=new PriorityQueue<>((i1,i2)->i2-i1);
        Arrays.stream(C).forEach(pQueue::offer);

        for(int i=0;i<A;i++){
            int seats=pQueue.poll();
            cost+=seats;
            if(seats>1)
                pQueue.offer(seats-1);
        }
        ans[0]=cost;

        cost=0;
        pQueue=new PriorityQueue<>();
        Arrays.stream(C).forEach(pQueue::offer);

        for(int i=0;i<A;i++){
            int seats=pQueue.poll();
            cost+=seats;
            if(seats>1)
                pQueue.offer(seats-1);
        }
        ans[1]=cost;
        return ans;
    }
}
