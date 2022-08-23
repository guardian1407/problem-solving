package com.guardian.problemsolving.scaler.twopointers;

public class MinimizeTheAbsoluteDifference {
    public static void main(String[] args) {
        int[] A={1, 4, 5, 8, 10};
        int[] B={6, 9, 15};
        int[] C={2, 3, 6, 6};
        System.out.print(solve(A,B,C));
    }
    private static int solve(int[] A, int[] B, int[] C){
        int a=0; int b=0; int c=0;
        int minDiff=Integer.MAX_VALUE;

        while(true){
            int max=Math.max(Math.max(A[a],B[b]),C[c]);
            int min=Math.min(Math.min(A[a],B[b]),C[c]);
            minDiff=Math.min(minDiff,Math.abs(max-min));

            if(A[a]<=B[b] && A[a]<=C[c]){
                if(a<A.length-1) a++;
                else break;
            }
            else if(B[b]<=A[a] && B[b]<=C[c]){
                if(b<B.length-1) b++;
                else break;
            }
            else{
                if(c<C.length-1) c++;
                else break;
            }
        }
        return minDiff;
    }
}
