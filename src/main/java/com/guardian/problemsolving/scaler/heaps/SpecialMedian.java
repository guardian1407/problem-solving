package com.guardian.problemsolving.scaler.heaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class SpecialMedian {
    public static void main(String[] args) {
        int[] A={2147483647, -2147483648, 0};
        System.out.println(solve(A));
    }
    private static int solve(int[] A) {
        return hasSpecialForward(A) || hasSpecialBackward(A) ? 1 : 0;
    }
    private static boolean hasSpecialForward(int[] A){
        Queue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minHeap=new PriorityQueue<>();
        int median=A[0];
        maxHeap.offer(median);
        for(int i=1;i<A.length;i++){
            int num=A[i];
            if(i%2==0){
                if(2*num==median)
                    return true;
            }
            else{
                if(num==median)
                    return true;
            }
            median=getMedian(maxHeap,minHeap,num);
        }
        return false;
    }
    private static boolean hasSpecialBackward(int[] A){
        Queue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minHeap=new PriorityQueue<>();
        int median=A[A.length-1];
        maxHeap.offer(median);
        for(int i=A.length-2;i>=0;i--){
            int num=A[i];
            if((A.length-i-1)%2==0){
                if(2*num==median)
                    return true;
            }
            else{
                if(num==median)
                    return true;
            }
            median=getMedian(maxHeap,minHeap,num);
        }
        return false;
    }
    private static int getMedian(Queue<Integer> maxHeap,Queue<Integer> minHeap,int num){
        int median;
        if(maxHeap.size()>minHeap.size()){
            if(num>=maxHeap.peek())
                minHeap.offer(num);
            else{
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            }
            int left=maxHeap.isEmpty()?0:maxHeap.peek();
            int right=minHeap.isEmpty()?0:minHeap.peek();
            median=left+right;

        }
        else if(maxHeap.size()<minHeap.size()){
            if(num<=minHeap.peek())
                maxHeap.offer(num);
            else{
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }
            int left=maxHeap.isEmpty()?0:maxHeap.peek();
            int right=minHeap.isEmpty()?0:minHeap.peek();
            median=left+right;
        }
        else{
            if(!maxHeap.isEmpty()){
                if(num>=maxHeap.peek() && num<=minHeap.peek()){
                    maxHeap.offer(num);
                    median=num;
                }
                else if(num<maxHeap.peek()){
                    maxHeap.offer(num);
                    median=maxHeap.peek();
                }
                else{
                    minHeap.offer(num);
                    median=minHeap.peek();
                }
            }
            else{
                maxHeap.offer(num);
                median=maxHeap.peek();
            }
        }
        return median;
    }
}
