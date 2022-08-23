package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.*;

public class SumOfMinAndMax {
    public static void main(String[] args) {
        int[] A={2, 5, -1, 7, -3, -1, -2};
        int B=4;
        System.out.print(solve(A,B));
    }
    private static int solve(int[] A, int B) {
        long mod=(long)1e9+7;
        long sum=0;
        Queue<List<Integer>> minQueue=new PriorityQueue<>(Comparator.comparingInt(l->l.get(0)));
        Queue<List<Integer>> maxQueue=new PriorityQueue<>((l1, l2)->l2.get(0)-l1.get(0));

        for(int i=0;i<B;i++){
            minQueue.add(new ArrayList<>(Arrays.asList(A[i],i)));
            maxQueue.add(new ArrayList<>(Arrays.asList(A[i],i)));
        }

        sum+=(minQueue.peek().get(0)%mod+maxQueue.peek().get(0)%mod)%mod;
        int i=1,j=B;
        while(j<A.length){
            minQueue.add(new ArrayList<>(Arrays.asList(A[j],j)));
            maxQueue.add(new ArrayList<>(Arrays.asList(A[j],j)));

            while(minQueue.peek().get(1)<i)
                minQueue.poll();

            while(maxQueue.peek().get(1)<i)
                maxQueue.poll();

            sum+=(minQueue.peek().get(0)%mod+maxQueue.peek().get(0)%mod)%mod;
            i++;j++;
        }
        sum%=mod;
        while(sum<0)
            sum+=mod;
        sum%=mod;
        return (int)sum;
    }
}
