package com.guardian.problemsolving.scaler.arrays;

public class OddEvenSubsequences {
    public static void main(String[] args) {
        int[] A={4,4,4,4,4};
        System.out.print(solve(A));
    }
    static int solve(int[] A) {
        int evenBit = A[0]%2==0 ? 1 : 0;
        int count = 1;

        for(int i=1;i<A.length;i++){
            if(evenBit==1 && A[i]%2!=0){
                count++;
                evenBit=0;
            }
            else if(evenBit==0 && A[i]%2==0){
                count++;
                evenBit=1;
            }
        }
        return count;
    }
}

