package com.guardian.problemsolving.scaler.arrays;

public class MultipleLeftRotations {
    public static void main(String[] args) {
        int[] A={5,4,6,7,8,9,0,1,2};
        int[] B={1,2,3,4,5,6,7,8,9,10};
        int[][] C=solve(A,B);
        for(int i=0; i<B.length; i++){
            for(int j=0; j<A.length; j++)
                System.out.print(C[i][j]+" ");
            System.out.println();
        }
    }
    static public int[][] solve(int[] A, int[] B) {
        int D[][]=new int[B.length][A.length];
        swapArray(A,0,A.length-1);

        for(int i=0; i<B.length; i++){
            int[] C=new int[A.length];
            int rotate=B[i]%A.length;
            int l=0;
            int r=A.length-1-rotate;
            copyArray(A,C,l,r);
            l=A.length-rotate;
            r=A.length-1;
            copyArray(A,C,l,r);
            D[i]=C;
        }
        return D;
    }
    static void swapArray(int[] A, int l, int r){
        while(l<r){
            int temp=A[l];
            A[l]=A[r];
            A[r]=temp;
            l++;
            r--;
        }
    }
    static void copyArray(int[] A, int[] B, int l, int r){
        while(l<r){
            B[l]=A[r];
            B[r]=A[l];
            l++;
            r--;
        }
        if(l==r)
            B[l]=A[l];
    }
}
