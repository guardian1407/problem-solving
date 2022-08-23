package com.guardian.problemsolving.scaler.dynamicprogramming;

public class MaxProductSubarray {
    public static void main(String[] args) {
        int[] A={4, 2, -5, 1};
        System.out.println(maxProduct(A));
    }
    private static int maxProduct(final int[] A) {
        int N=A.length;
        int res=A[0];
        int max=res, min=res;
        for(int i=1;i<N;i++){
            int curr_max=Math.max(A[i],Math.max(A[i]*max,A[i]*min));
            int curr_min=Math.min(A[i],Math.min(A[i]*max,A[i]*min));;
            max=curr_max;
            min=curr_min;
            res=Math.max(res,max);
        }
        return res;
    }
}
