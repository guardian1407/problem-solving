package com.guardian.problemsolving.scaler.arrays;

public class FirstMissingInteger {
    public static void main(String[] args){
        int[] A={3, 4, -1, 1};
        System.out.print(firstMissingPositive(A));
    }
    private static int firstMissingPositive(int[] A){
        int i=0;
        while(i<A.length){
            if(A[i]>=1 && A[i]<=A.length && A[A[i]-1]!=A[i])
                swap(A,i,A[i]-1);
            else 
                i++;
        }
        i=0;
        while(i<A.length && A[i]==i+1)
            i++;
        return i+1;
    }
    private static void swap(int[] A,int i,int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
}
