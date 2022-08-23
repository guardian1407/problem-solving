package com.guardian.problemsolving.scaler.greedyalgorithm;

public class Bulbs {
    public static void main(String[] args) {
        int[] A={0, 1, 0, 1};
        System.out.print(bulbs(A));
    }
    private static int bulbs(int[] A){
        int count=0;
        for(int i=0;i<A.length;i++){
            if((count%2==0 && A[i]==0) || (count%2!=0 && A[i]==1))
                count++;
        }
        return count;
    }
}
