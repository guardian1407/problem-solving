package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.*;

public class NIntegersContainingOnly12and3 {
    public static void main(String[] args) {
        int A=7;
        Arrays.stream(solve(A)).forEach(e->System.out.print(e+" "));
    }
    private static int[] solve(int A) {
        List<Integer> ans=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>(Arrays.asList(1, 2, 3));
        int i=0;

        while(i++<A){
            int e=queue.poll();
            queue.addAll(Arrays.asList(e*10+1, e*10+2, e*10+3));
            ans.add(e);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
