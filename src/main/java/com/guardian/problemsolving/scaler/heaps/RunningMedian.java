package com.guardian.problemsolving.scaler.heaps;

import java.util.*;

public class RunningMedian {
    public static void main(String[] args) {
        int[] A= {15, 20, 99, 1};
        Arrays.stream(solve(A)).forEach(e->System.out.print(e+" "));
    }
    private static int[] solve(int[] A){
        int[] res=new int[A.length];
        Queue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minHeap=new PriorityQueue<>();
        int median=A[0];
        res[0]=median;
        for(int i=1;i<A.length;i++){
            Integer num=A[i];
            if(maxHeap.size()>minHeap.size()){
                Integer left=maxHeap.peek();
                if(num>=median)
                    minHeap.offer(num);
                else{
                    minHeap.offer(median);
                    if(num>=left)
                        median=num;
                    else{
                        median=left;
                        maxHeap.poll();
                        maxHeap.offer(num);
                    }
                }
            }
            else if(maxHeap.size()<minHeap.size()){
                Integer right=minHeap.peek();
                if(num<=median)
                    maxHeap.offer(num);
                else{
                    maxHeap.offer(median);
                    if(num<=right)
                        median=num;
                    else{
                        median=right;
                        minHeap.poll();
                        minHeap.offer(num);
                    }
                }
            }
            else{
                if(num>=median)
                    minHeap.offer(num);
                else{
                    minHeap.offer(median);
                    if(maxHeap.size()==0 || num>=maxHeap.peek())
                        median=num;
                    else{
                        median=maxHeap.poll();
                        maxHeap.offer(num);
                    }
                }
            }
            res[i]=median;
        }
        return res;
    }
}
