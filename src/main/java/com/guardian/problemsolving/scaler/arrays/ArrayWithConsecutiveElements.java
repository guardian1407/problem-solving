package com.guardian.problemsolving.scaler.arrays;

import java.util.Arrays;

public class ArrayWithConsecutiveElements {
    public static void main(String[] args){
        int[] A= {3,2,1,4,6,5};
        System.out.print(solve(A));
    }
    private static int solve(int[] A){
        Arrays.sort(A);
        int ans=1;

        for(int i=1;i<A.length;++i){
            if(A[i-1]+1!=A[i]){
                ans=0;
                break;
            }
        }
        return ans;
    }
}
