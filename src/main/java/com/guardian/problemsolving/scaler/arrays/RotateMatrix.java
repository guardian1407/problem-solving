package com.guardian.problemsolving.scaler.arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] A={{1,2},{3,4}};
        solve(A);
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length;j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    private static void solve(int[][] A){
        int N=A.length;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                swap(A,i,j,j,i);
            }
        }
        for(int i=0;i<N;i++){
            int l=0;int r=N-1;
            while(l<r){
                swap(A,i,l,i,r);
                l++; r--;
            }
        }
    }
    private static void swap(int[][] A,int i,int j,int p,int q){
        int temp=A[i][j];
        A[i][j]=A[p][q];
        A[p][q]=temp;
    }
}
