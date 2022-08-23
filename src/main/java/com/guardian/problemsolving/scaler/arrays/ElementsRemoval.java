package com.guardian.problemsolving.scaler.arrays;

import java.util.Arrays;

public class ElementsRemoval {
    public static void main(String[] args){
        int[] A= {8, 0, 10};
        System.out.print(solve(A));
    }
    private static int solve(int[] A){
        Arrays.sort(A);
        int N=A.length;
        int l=0; int r=N-1;
        int sum=0;

        while(l<r){
            swap(A,l,r);
            l++; r--;
        }

        for(int i=0;i<N;i++)
            sum+=A[i];

        int cost=sum;

        for(int i=1;i<N;i++){
            sum-=A[i-1];
            cost+=sum;
        }
        return cost;
    }
    private static void swap(int[] A,int i,int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
}
