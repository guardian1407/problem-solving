package com.guardian.problemsolving.scaler.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class AthLargestElement {
    public static void main(String[] args) {
        ArrayList<Integer> B=new ArrayList<>(Arrays.asList(15, 20, 99, 1));
        int A=2;
        solve(A,B).forEach(e->System.out.print(e+" "));
    }
    private static ArrayList<Integer> solve(int A, ArrayList<Integer> B){
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> pQueue=new PriorityQueue<>();
        int i=0;

        while(i<A){
            pQueue.offer(B.get(i));
            if(i<A-1)
                ans.add(-1);
            else if(!pQueue.isEmpty())
                ans.add(pQueue.peek());
            i++;
        }

        while(i<B.size()){
            if(B.get(i)>pQueue.peek()){
                pQueue.poll();
                pQueue.offer(B.get(i));
            }
            ans.add(pQueue.peek());
            i++;
        }
        return ans;
    }
}
