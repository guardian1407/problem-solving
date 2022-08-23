package com.guardian.problemsolving.scaler.heaps;

import java.util.*;

public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(9, 11, 15)));
        A.add(new ArrayList<>(Arrays.asList(10, 15, 17)));
        int B=6;

        System.out.print(solve(A,B));
    }
    private static int solve(ArrayList<ArrayList<Integer>> A, int B) {
        Queue<Integer> pQueue=new PriorityQueue<>();
        A.forEach(list->list.forEach(pQueue::offer));

        for(int i=0;i<B-1;i++)
            pQueue.poll();
        return pQueue.peek();
    }
}
