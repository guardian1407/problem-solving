package com.guardian.problemsolving.scaler.twopointers;

public class SortByColor {
    public static void main(String[] args) {
        int[] A={2,2,2,1,1,1,0,0,0,1,0,2};
        A=sortColors2(A);
        for(int i=0; i<A.length; i++)
            System.out.print(A[i]+" ");
    }
    static int[] sortColors(int[] A) {
        int j=0;
        int k=A.length-1;

        for(int i=0;i<=k;i++){
            if(A[i]==0)
                swap(A,i,j++);
            else if(A[i]==2)
                swap(A,i--,k--);
        }
        return A;
    }
    static int[] sortColors1(int[] A) {
        int j=0;
        int k=A.length-1;

        for(int i=0;i<=k;i++){
            if(A[i]==0 && i!=j)
                swap(A,i--,j++);
            else if(A[i]==2 && i!=k)
                swap(A,i--,k--);
        }
        return A;
    }
    static int[] sortColors2(int[] A) {
        int n0=-1;
        int n1=-1;
        int n2=-1;

        for(int i=0;i<A.length;i++){
            if (A[i] == 0)
            {
                A[++n2] = 2; A[++n1] = 1; A[++n0] = 0;
            }
            else if (A[i] == 1)
            {
                A[++n2] = 2; A[++n1] = 1;
            }
            else if (A[i] == 2)
            {
                A[++n2] = 2;
            }
        }
        return A;
    }
    static void swap(int[] A,int l, int r){
        int temp=A[l];
        A[l]=A[r];
        A[r]=temp;
    }
}
