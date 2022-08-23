package com.guardian.problemsolving.scaler.strings;

public class RotateString {
    public static void main(String[] args) {
        String A="academy";
        int B=8;
        System.out.print(solve(A,B));
    }
    static String solve(String A, int B) {
        String[] C=A.split("");
        B%=C.length;
        swap(C, 0, C.length-1);
        swap(C, 0, B-1);
        swap(C, B, C.length-1);

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < C.length; i++) {
            sb.append(C[i]);
        }
        return sb.toString();
    }
    static void swap(String[] A, int l, int r){
        while (l < r){
            String temp=A[l];
            A[l]=A[r];
            A[r]=temp;
            l++;
            r--;
        }
    }
}
