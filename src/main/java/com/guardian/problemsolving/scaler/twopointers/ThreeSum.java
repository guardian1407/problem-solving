package com.guardian.problemsolving.scaler.twopointers;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        int[] A={-1, 2, 1, -4};
        int B=1;
        System.out.print(threeSumClosest(A,B));
    }
    private static int threeSumClosest(int[] A, int B) {
        int minDiff=Integer.MAX_VALUE;
        int sum=0;
        Arrays.sort(A);
        for(int i=0;i<A.length;i++){
            int l=i+1,r=A.length-1;
            while(l<r){
                int diff=Math.abs(B-(A[i]+A[l]+A[r]));
                if(diff<minDiff){
                    sum=A[i]+A[l]+A[r];
                    minDiff=diff;
                }
                if(A[i]+A[l]+A[r]>B)
                    r--;
                else if(A[i]+A[l]+A[r]<B)
                    l++;
                else
                    return A[i]+A[l]+A[r];
            }
        }
        return sum;
    }
}
