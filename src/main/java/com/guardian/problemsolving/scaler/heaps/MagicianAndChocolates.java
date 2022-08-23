package com.guardian.problemsolving.scaler.heaps;

import java.util.*;

public class MagicianAndChocolates {
    public static void main(String[] args) {
        ArrayList<Integer> B=new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        int A=5;
        System.out.print(nchoc(A,B));
    }
    private static int nchoc(int A, ArrayList<Integer> B) {
        long mod=(long)1e9+7;
        Queue<Integer> pQueue=new PriorityQueue<>(Collections.reverseOrder());
        B.forEach(pQueue::offer);
        long count=0;

        for(int i=0;i<A;i++){
            int bag=pQueue.poll();
            count+=bag%mod;
            pQueue.offer(bag/2);
        }

        count%=mod;
        while(count<0) {
            count+=mod;
        }
        count%=mod;
        return (int)count;
    }
}
