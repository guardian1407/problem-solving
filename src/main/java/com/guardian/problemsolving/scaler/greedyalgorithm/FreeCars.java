package com.guardian.problemsolving.scaler.greedyalgorithm;

import java.util.*;

public class FreeCars {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(1, 3, 2, 3, 3));
        ArrayList<Integer> B=new ArrayList<>(Arrays.asList(5, 6, 1, 3, 9));
        System.out.print(solve(A,B));
    }
    private static int solve(ArrayList<Integer> A, ArrayList<Integer> B){
        long mod=(long)1e9+7;
        int N=A.size();
        Queue<Car> pQueue=new PriorityQueue<>(Collections.reverseOrder());
        TreeSet<Integer> treeSet=new TreeSet<>();
        long maxProfit=0;

        for(int i=0;i<N;i++){
            pQueue.offer(new Car(A.get(i),B.get(i)));
            treeSet.add(i);
        }

        while(!pQueue.isEmpty()){
            Car car=pQueue.poll();
            Integer day=treeSet.floor(car.time-1);

            if(day!=null){
                maxProfit+=car.profit%mod;
                treeSet.remove(day);
            }
        }

        maxProfit%=mod;
        while(maxProfit<0)
            maxProfit+=mod;
        maxProfit%=mod;

        return (int)maxProfit;
    }
    private static class Car implements Comparable<Car>{
        int time;
        int profit;

        public Car(int time, int profit) {
            this.time = time;
            this.profit = profit;
        }

        @Override
        public int compareTo(Car o) {
            if(this.profit!=o.profit)
                return this.profit-o.profit;
            else
                return this.time-o.time;
        }
    }
}
