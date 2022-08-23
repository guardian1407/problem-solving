package com.guardian.problemsolving.scaler.arrays;

public class BeggarsOutsideTemple {
    public static void main(String[] args) {
        int A=5;
        int[][] B={{1, 2, 10},{2, 3, 20},{2, 5, 25}};
        int[] C=solve(A,B);

        for(int i = 0; i < C.length; i++)
            System.out.print(C[i]+" ");
    }
    static int[] solve(int A, int[][] B){
        int[] psa=new int[A];

        for(int i=0;i<B.length;i++){
            int l=B[i][0];
            int r=B[i][1];
            int coins=B[i][2];

            psa[l-1]+=coins;
            if(r<A) psa[r]-=coins;
        }

        for(int i=1;i<psa.length;i++){
            psa[i]+=psa[i-1];
        }
        return psa;
    }
}
