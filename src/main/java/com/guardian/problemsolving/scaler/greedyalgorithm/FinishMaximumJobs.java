package com.guardian.problemsolving.scaler.greedyalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class FinishMaximumJobs {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(1, 5, 7, 1));
        ArrayList<Integer> B=new ArrayList<>(Arrays.asList(7, 8, 8, 8));
        System.out.print(solve(A,B));
    }
    private static int solve(ArrayList<Integer> A, ArrayList<Integer> B){
        int N=A.size();
        Queue<Job> pQueue=new PriorityQueue<>();
        int ans=0;
        int lastEnd=0;

        for(int i=0;i<N;i++)
            pQueue.offer(new Job(A.get(i),B.get(i)));

        while(!pQueue.isEmpty()){
            Job job=pQueue.poll();

            if(job.start>=lastEnd){
                ans+=1;
                lastEnd=job.end;
            }
        }
        return ans;
    }
    private static class Job implements Comparable<Job>{
        int start;
        int end;

        public Job(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Job o) {
            if(this.end>o.end || (this.end==o.end && this.start>o.start))
                return 1;
            else if(this.end==o.end && this.start==o.start)
                return 0;
            else
                return -1;
        }
    }
}
