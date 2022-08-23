package com.guardian.problemsolving.scaler.arrays;

public class MaxSumContiguousSubarray {
    public static void main(String[] args) {
        int[] A={-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.print(maxSubArray(A));
    }
    private static int maxSubArray(final int[] A) {
        int max=A[0];
        int sum=0;

        for(int i=0;i<A.length;i++){
            sum+=A[i];
            if(sum>max)
                max=sum;
            if(sum<0)
                sum=0;
        }
        return max;
    }
}
