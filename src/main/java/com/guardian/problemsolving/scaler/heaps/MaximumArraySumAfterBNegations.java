package com.guardian.problemsolving.scaler.heaps;

import java.util.*;

public class MaximumArraySumAfterBNegations {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(57, 3, -14, -87, 42, 38, 31, -7, -28, -61));
        int B=10;
        System.out.print(solve(A,B));
    }
    private static int solve(ArrayList<Integer> A, int B) {
        Queue<Integer> pQueue=new PriorityQueue<>();
        int sum=A.stream()
                .peek(pQueue::offer)
                .mapToInt(e->e)
                .sum();

        for(int i=0;i<B;i++){
            int e=-pQueue.poll();
            sum+=2*e;
            pQueue.offer(e);
        }
        return sum;
    }
}
