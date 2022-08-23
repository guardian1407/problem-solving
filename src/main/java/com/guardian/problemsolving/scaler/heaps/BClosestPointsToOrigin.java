package com.guardian.problemsolving.scaler.heaps;

import java.util.*;

public class BClosestPointsToOrigin {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1, -1)));
        A.add(new ArrayList<>(Arrays.asList(2, -1)));
        int B=1;

        solve(A,B).forEach(list->{
            list.forEach(node->System.out.print(node+" "));
            System.out.println();
        });
    }
    private static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Queue<ArrayList<Integer>> pQueue=
                new PriorityQueue<>(Comparator.comparingDouble(p->Math.sqrt(p.get(0)*p.get(0)+p.get(1)*p.get(1))));

        A.forEach(pQueue::offer);
        for(int i=0;i<B;i++)
            ans.add(pQueue.poll());

        return ans;
    }
}
