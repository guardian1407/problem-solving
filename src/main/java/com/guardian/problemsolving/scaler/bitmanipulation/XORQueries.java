package com.guardian.problemsolving.scaler.bitmanipulation;

public class XORQueries {
    public static void main(String[] args) {
        int[] A={1,0,0,0,1};
        int[][] B={{2,4},{1,5},{3,5}};
        B=solve(A,B);

        for(int i=0;i<B.length;i++)
            System.out.println(B[i][0]+" "+B[i][1]);
    }
    private static int[][] solve(int[] A, int[][] B){
        int[] P=new int[A.length];
        int sum=0;

        for(int i=0;i<A.length;i++){
            sum+=A[i];
            P[i]=sum;
        }

        for(int i=0;i<B.length;i++){
            int l=B[i][0]-1;
            int r=B[i][1]-1;
            int size=r-l+1;
            int sumRange=l>0 ? P[r]-P[l-1] : P[r];

            B[i][0]=sumRange%2==0 ? 0 : 1;
            B[i][1]=size-sumRange;
        }
        return B;
    }
}
