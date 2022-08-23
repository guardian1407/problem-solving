package com.guardian.problemsolving.scaler.arrays;

public class LeastAverageSubArray {
    public static void main(String[] args) {
        int[] A={3, 7, 5, 20, -10, 0, 12};
        int B=2;
        System.out.print(solve(A,B));
    }
    static int solve(int[] A, int B){
        int l=0;
        int r=B-1;
        int sum=0;

        for(int i=0;i<=r;i++)
            sum+=A[i];

        int minSum=sum;
        int minIndex=0;

        while(++r<A.length){
            sum=sum-A[l]+A[r];
            l++;
            if(sum<minSum){
                minSum=sum;
                minIndex=l;
            }
        }
        return minIndex;
    }
}
