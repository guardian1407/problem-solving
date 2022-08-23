package com.guardian.problemsolving.scaler.arrays;

public class MaximumAbsoluteDifference {
    public static void main(String[] args){
        int[] A={1, 3, -1};
        System.out.print(maxArr(A));
    }
    private static int maxArr(int[] A){
        int N=A.length;
        int sumMax=Integer.MIN_VALUE;
        int sumMin=Integer.MAX_VALUE;
        int diffMax=Integer.MIN_VALUE;
        int diffMin=Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            sumMax=Math.max(sumMax,A[i]+i);
            sumMin=Math.min(sumMin,A[i]+i);
            diffMax=Math.max(diffMax,A[i]-i);
            diffMin=Math.min(diffMin,A[i]-i);
        }
        return Math.max(sumMax-sumMin,diffMax-diffMin);
    }
}
