package com.guardian.problemsolving.scaler.arrays;

public class GoodPair {
    public static void main(String[] args) {
        int[] arr2={4,7,7,8,9,9,6,2};
        System.out.println("Good Pair: "+solve(arr2,18));
    }
    private static int solve(int[] A, int B) {
        for(int i = 0; i<A.length; i++){
            for(int j = i+1; j<A.length; j++){
                if(A[i]+A[j] == B)
                    return 1;
            }
        }
        return 0;
    }
}
