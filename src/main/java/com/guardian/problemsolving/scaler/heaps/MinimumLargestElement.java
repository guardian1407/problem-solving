package com.guardian.problemsolving.scaler.heaps;

import java.util.*;

public class MinimumLargestElement {
    public static void main(String[] args) {
        int[] A={5, 1, 4, 2};
        int B=5;
        System.out.print(solve(A,B));
    }
    private static int solve(int[] A, int B) {
        int max=Integer.MIN_VALUE;
        Queue<List<Integer>> pQueue=new PriorityQueue<>(Comparator.comparingInt(l->l.get(0)));
        for(int i=0;i<A.length;i++){
            pQueue.offer(new ArrayList<>(Arrays.asList(2*A[i],A[i])));
            max=Math.max(max,A[i]);
        }
        for(int i=0;i<B;i++){
            List<Integer> l=pQueue.poll();
            max=Math.max(max,l.get(0));
            l.set(0,l.get(0)+l.get(1));
            pQueue.offer(l);
        }
        return max;
    }
}
