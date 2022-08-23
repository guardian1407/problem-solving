package com.guardian.problemsolving.scaler.strings;

public class ReverseTheString {
    public static void main(String[] args) {
        String A="       fwbpudnbrozzifml osdt ulc jsx kxorifrhubk ouhsuhf sswz qfho dqmy sn myq igjgip iwfcqq                 ";
        System.out.print(solve(A));
    }
    static String solve(String A) {
        A=A.trim();
        String[] B=A.split("\\s+");
        int l=0;
        int r=B.length-1;

        while(l<r){
            String temp=B[l];
            B[l]=B[r];
            B[r]=temp;
            l++;
            r--;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(B[0]);
        for(int i = 1; i < B.length; i++) {
            sb.append(" ");
            sb.append(B[i]);
        }
        return sb.toString();
    }
}
