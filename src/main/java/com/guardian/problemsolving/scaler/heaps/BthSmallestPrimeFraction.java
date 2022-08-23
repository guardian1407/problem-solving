package com.guardian.problemsolving.scaler.heaps;

import java.util.*;

public class BthSmallestPrimeFraction {
    public static void main(String[] args) {
        int[] A={1, 2, 3, 5};
        int B=3;
        Arrays.stream(solve(A,B)).forEach(e->System.out.print(e+" "));
    }
    private static int[] solve(int[] A, int B) {
        Queue<List<Integer>> pQueue=new PriorityQueue<>((l1,l2)->l1.get(0)*l2.get(1)-l1.get(1)*l2.get(0));
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                int p=A[i];
                int q=A[j];
                if(p<q)
                    pQueue.offer(new ArrayList<>(Arrays.asList(p,q)));
            }
        }
        while(B>1){
            pQueue.poll();
            B--;
        }
        return pQueue.poll().stream().mapToInt(Integer::intValue).toArray();
    }
}
