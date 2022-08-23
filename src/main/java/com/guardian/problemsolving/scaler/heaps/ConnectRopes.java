package com.guardian.problemsolving.scaler.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ConnectRopes {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(5, 17, 100, 11));
        System.out.print(solve(A));
    }
    private static int solve(ArrayList<Integer> A){
        Queue<Integer> pQueue=new PriorityQueue<>();
        A.forEach(pQueue::offer);
        int cost=0;
        int curr=pQueue.poll();

        while(!pQueue.isEmpty()){
            int next=pQueue.poll();
            cost+=curr+next;
            pQueue.offer(curr+next);
            curr=pQueue.poll();
        }
        return cost;
    }
}
