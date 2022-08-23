package com.guardian.problemsolving.scaler.twopointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] A={1, 5, 4, 3};
        System.out.print(maxArea(A));
    }
    private static int maxArea(int[] A){
        int maxArea=0;
        int l=0;
        int r=A.length-1;

        while(l<r){
            maxArea=Math.max(maxArea,Math.min(A[l],A[r])*(r-l));
            if(A[l]<A[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }
}
