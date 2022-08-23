package com.guardian.problemsolving.scaler.arrays;

public class TimeToEquality {
    public static void main(String[] args) {
        int[] arr2={4,7,7,8,9,9,6,2};
        System.out.println("Time: "+solve(arr2));
    }
    private static int solve(int[] A) {
        int time = 0;
        int max = A[0];
        for(int i = 1; i<A.length; i++){
            if(A[i]>max)
                max = A[i];
        }

        for(int i = 0; i<A.length; i++){
            time += max-A[i];
        }
        return time;
    }
}

