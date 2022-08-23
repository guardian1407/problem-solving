package com.guardian.problemsolving.scaler.arrays;

public class SpiralOrderMatrixII {
    public static void main(String[] args) {
        int A=5;
        int[][] B=generateMatrix(A);
        for(int i=0;i<B.length;i++){
            for(int j=0;j<B[i].length;j++){
                System.out.print(B[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    private static int[][] generateMatrix(int A){
        int[][] C=new int[A][A];
        int T=0; int B=A-1; int L=0; int R=A-1;
        int num=1;
        while(T<=B && L<=R){
            for(int i=L;i<=R;i++){
                C[T][i]=num++;
            }
            T++;
            for(int i=T;i<=B;i++){
                C[i][R]=num++;
            }
            R--;
            for(int i=R;i>=L;i--){
                C[B][i]=num++;
            }
            B--;
            for(int i=B;i>=T;i--){
                C[i][L]=num++;
            }
            L++;
        }
        return C;
    }
}
