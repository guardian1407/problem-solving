package com.guardian.problemsolving.scaler.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ProductOf3 {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(10, 2, 13, 4));
        solve(A).forEach(e->System.out.print(e+" "));
    }
    private static ArrayList<Integer> solve(ArrayList<Integer> A){
        int N=A.size();
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> pQueue=new PriorityQueue<>();
        int product=1;
        int i=0;

        while(i<3 && i<N){
            int e=A.get(i);
            pQueue.offer(e);
            product*=e;

            if(i<2)
                ans.add(-1);
            else
                ans.add(product);
            i++;
        }

        while(i<N){
            int e=A.get(i);

            if(pQueue.peek()<e){
                int min=pQueue.poll();
                product=(product/min)*e;
                pQueue.offer(e);
            }
            ans.add(product);
            i++;
        }
        return ans;
    }
}
