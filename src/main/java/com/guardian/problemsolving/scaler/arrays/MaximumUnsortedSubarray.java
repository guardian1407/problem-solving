package com.guardian.problemsolving.scaler.arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class MaximumUnsortedSubarray {
    public static void main(String[] args) {
        int[] A={4, 15, 4, 4, 15, 18, 20};
        Arrays.stream(subUnsort(A)).forEach(e->System.out.print(e+" "));
    }
    private static int[] subUnsort(int[] A) {
        int l=0;
        while(l<A.length-1){
            if(A[l]>A[l+1])
                break;
            else
                l++;
        }
        if(l==A.length-1)
            return Stream.of(-1).mapToInt(Integer::intValue).toArray();

        int r=A.length-1;
        while(r>0){
            if(A[r]<A[r-1])
                break;
            else
                r--;
        }

        int max=A[l];
        int min=A[l];
        for(int i=l+1;i<=r;i++){
            max=Math.max(max,A[i]);
            min=Math.min(min,A[i]);
        }

        for(int i=0;i<l;i++)
            if(A[i]>min){
                l=i;
                break;
            }

        for(int i=A.length-1;i>r;i--)
            if(A[i]<max){
                r=i;
                break;
            }
        return Stream.of(l,r).mapToInt(Integer::intValue).toArray();
    }
}
