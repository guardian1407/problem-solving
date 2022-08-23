package com.guardian.problemsolving.scaler.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KPlacesApart {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(2, 1, 17, 10, 21, 95));
        int B=1;
        solve(A,B).forEach(e->System.out.print(e+" "));
    }
    private static ArrayList<Integer> solve(ArrayList<Integer> A, int B){
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> pQueue=new PriorityQueue<>();
        int i=0;

        while(i<B+1){
            pQueue.offer(A.get(i));
            i++;
        }

        while(i<A.size()){
            ans.add(pQueue.poll());
            pQueue.offer(A.get(i));
            i++;
        }

        while(!pQueue.isEmpty())
            ans.add(pQueue.poll());
        return ans;
    }
}
