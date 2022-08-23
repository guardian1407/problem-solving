package com.guardian.problemsolving.scaler.dynamicprogramming;

public class SubMatrixSumQueries {
    public static void main(String[] args) {
        int[][] A={{5, 17, 100, 11}, {0, 0,  2,   8}};
        int[] B={1, 1};
        int[] C={1, 4};
        int[] D={2, 2};
        int[] E={2, 4};
        int[] F=solve(A,B,C,D,E);

        for(int i=0;i<A.length;i++)
            System.out.print(F[i] + " ");
    }
    private static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E){
        long M=(long)1e9+7;
        long[][] P=new long[A.length][A[0].length];
        int[] ans=new int[B.length];

        //2D prefix sum array
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length;j++){
                int prevRow=i-1;
                int prevCol=j-1;

                if(prevRow>=0 && prevCol>=0)
                    P[i][j]=(P[prevRow][j]%M+P[i][prevCol]%M-P[prevRow][prevCol]%M+A[i][j]%M)%M;
                if(prevRow>=0 && prevCol<0)
                    P[i][j]=(P[prevRow][j]%M+A[i][j]%M)%M;
                if(prevRow<0 && prevCol>=0)
                    P[i][j]=(P[i][prevCol]%M+A[i][j]%M)%M;
                if(prevRow<0 && prevCol<0)
                    P[i][j]=A[i][j]%M;
            }
        }

        //using prefix sum array for finding output for each query
        for(int i=0;i<B.length;i++){
            int prevB=B[i]-2;
            int prevC=C[i]-2;
            long sum=0;

            if(prevB>=0 && prevC>=0)
                sum=P[D[i]-1][E[i]-1]%M-P[D[i]-1][prevC]%M-P[prevB][E[i]-1]%M+P[prevB][prevC]%M;
            if(prevB>=0 && prevC<0)
                sum=P[D[i]-1][E[i]-1]%M-P[prevB][E[i]-1]%M;
            if(prevB<0 && prevC>=0)
                sum=P[D[i]-1][E[i]-1]%M-P[D[i]-1][prevC]%M;
            if(prevB<0 && prevC<0)
                sum=P[D[i]-1][E[i]-1]%M;

            sum%=M;

            while(sum<0) {
                sum+=M;
            }
            sum%=M;
            ans[i]=(int)sum;
        }
        return ans;
    }
}
