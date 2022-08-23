package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] A={251, 286, 420, 491, 506, 34, 716, 829, 615, 53, 807, 837, 750, 650, 181, 140, 543, 944, 210, 113, 551,
                379, 818, 817, 227, 525, 257, 735, 932, 172, 410, 935, 351, 347, 521, 168, 482, 885, 612, 352};
        int B=9;
        Arrays.stream(slidingMaximum(A,B)).forEach(e->System.out.print(e+" "));
    }
    private static int[] slidingMaximum(final int[] A, int B) {
        List<Integer> ans=new ArrayList<>();
        Queue<List<Integer>> queue=new PriorityQueue<>((l1,l2)->l2.get(0)-l1.get(0));

        for(int i=0;i<Math.min(A.length,B);i++)
            queue.add(new ArrayList<>(Arrays.asList(A[i],i)));

        ans.add(queue.peek().get(0));
        if(A.length>B){
            int i=1,j=B;
            while(j<A.length){
                queue.add(new ArrayList<>(Arrays.asList(A[j],j)));
                while(queue.peek().get(1)<i)
                    queue.poll();
                ans.add(queue.peek().get(0));
                i++;j++;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
