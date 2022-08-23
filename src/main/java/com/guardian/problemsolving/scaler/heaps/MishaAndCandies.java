package com.guardian.problemsolving.scaler.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MishaAndCandies {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(3, 2, 3));
        int B=4;

        System.out.print(solve(A,B));
    }
    private static int solve(ArrayList<Integer> A, int B) {
        Queue<Integer> pQueue=new PriorityQueue<>();
        A.forEach(pQueue::offer);
        int count=0;
        int box=0;
        int half=0;

        while(!pQueue.isEmpty() && pQueue.peek()<=B){
            pQueue.offer(pQueue.poll()+(box-half));
            box=pQueue.poll();
            half=box/2;

            if(box<=B)
                count+=half;
        }
        return count;
    }
}
