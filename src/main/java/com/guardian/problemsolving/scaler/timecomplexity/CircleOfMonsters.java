package com.guardian.problemsolving.scaler.timecomplexity;

public class CircleOfMonsters {
    public static void main(String[] args) {
//        int[] A={7,2,5};
//        int[] B={15,14,3};
        int[] A={75, 99, 92, 100, 73, 52, 67, 97, 66, 61, 81, 50, 65, 91, 88, 93, 95, 55, 57, 53, 94, 81, 67, 86, 79, 80, 60, 66, 94, 62, 58, 99, 64, 75, 91, 64, 64, 90, 67, 60, 69, 94, 50, 95, 65, 96, 100, 74, 91, 96, 92, 65, 68, 65, 62};
        int[] B={84, 82, 76, 78, 56, 89, 52, 89, 73, 56, 69, 86, 86, 56, 89, 56, 100, 53, 81, 75, 56, 98, 73, 60, 55, 73, 95, 64, 91, 83, 57, 82, 53, 89, 100, 83, 95, 63, 62, 53, 60, 64, 83, 99, 74, 54, 97, 80, 72, 95, 83, 51, 66, 91, 64};
        System.out.print(solve(A,B));
    }

    static long solve(int[] A, int[] B) {
        long M = (long)1e9+7;
        int n = A.length;
        long totalBullets = 0;
        long minVal=Long.MAX_VALUE;

        for(int i=0; i<n; i++){
            long netHealth = Math.max(0,A[(i+1)%n]-B[i]);

            if(netHealth > 0)
                minVal = Math.min(minVal,B[i]);
            else
                minVal = Math.min(minVal,A[(i+1)%n]);

            totalBullets += netHealth;
        }
        totalBullets += minVal;
        return totalBullets%M;
    }
}
