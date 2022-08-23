package com.guardian.problemsolving.scaler.arrays;

public class StepwiseSelectionSort {
    public static void main(String[] args){
        int[] A={6, 4, 3, 7, 2, 8};
        int[] B=solve(A);
        for(int i=0;i<B.length;i++)
            System.out.print(B[i]+" ");
    }
    private static int[] solve(int[] A){
        int[] B=new int[A.length-1];

        for(int i=0;i<A.length-1;i++){
            int min=A[i];
            int minIndex=i;
            for(int j=i;j<A.length;j++){
                if(A[j]<min){
                    min=A[j];
                    minIndex=j;
                }
            }
            swap(A,i,minIndex);
            B[i]=minIndex;
        }
        return B;
    }
    private static void swap(int[] A,int i,int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
}
