package com.guardian.problemsolving.scaler.test;

public class Test2 {
    public static void main(String[] s){
        int[] A = {1,2,3,4,-5};
        System.out.print(solve(A));
    }
    static int[] solve(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && i % 2 == 0 || A[i] <= 0 && i % 2 != 0) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] > 0 && i % 2 != 0 || A[j] <= 0 && i % 2 == 0) {
                        swap(A, i, j);
                        swap(A, i + 1, j);
                    }
                }
            }
        }
        return A;
    }
    static void swap(int[] A,int l,int r){
        while(l<r){
            int temp=A[l];
            A[l]=A[r];
            A[r]=temp;
            l++;
            r--;
        }
    }
}
