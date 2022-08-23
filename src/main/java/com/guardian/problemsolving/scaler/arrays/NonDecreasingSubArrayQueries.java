package com.guardian.problemsolving.scaler.arrays;

public class NonDecreasingSubArrayQueries {
    public static void main(String[] args) {
        int[] A={1, 7, 3, 4, 9};
        int[][] B={{1, 2},{2, 4}};
        int[] C=solve(A,B);

        for(int i=0;i<C.length;i++)
            System.out.print(C[i] + " ");
    }
    private static int[] solve(int[] A, int[][] B){
        int[] P=new int[A.length];
        int[] ans=new int[B.length];
        P[0]=0;

        for(int i=1;i<A.length;i++){
            int fault=A[i]<A[i-1] ? 1 : 0;
            P[i]=P[i-1]+fault;
        }

        for(int i=0;i<B.length;i++){
            int l=B[i][0]-1;
            int r=B[i][1]-1;

            ans[i]=P[r]-P[l]>0 ? 0 : 1;
        }
        return ans;
    }
}
