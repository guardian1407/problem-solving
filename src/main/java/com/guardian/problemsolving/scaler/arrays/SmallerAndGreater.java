package com.guardian.problemsolving.scaler.arrays;

public class SmallerAndGreater {
    public static void main(String[] args) {
        int[] A = {4,7,7,8,9,9,6,2};
        System.out.print(solve(A));
    }
    static int solve(int[] A) {
        int count = 0;
        int maxVal = A[0];
        int minVal = A[0];
        for(int i=1; i<A.length; i++) {
            if(A[i]>maxVal)
                maxVal=A[i];
            if(A[i]<minVal)
                minVal=A[i];
        }
        for(int i=0; i<A.length; i++) {
            if(A[i]>minVal && A[i]<maxVal)
                count++;
        }
        return count;
    }
}
