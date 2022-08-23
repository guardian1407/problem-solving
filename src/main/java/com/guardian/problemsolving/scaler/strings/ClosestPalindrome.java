package com.guardian.problemsolving.scaler.strings;

public class ClosestPalindrome {
    public static void main(String[] args){
        String A="abbba";
        System.out.print(solve(A));
    }
    private static String solve(String A){
        int N=A.length();
        int l=0; int r=N-1;
        int count=0;

        while(l<r){
           if(A.charAt(l)!=A.charAt(r))
               count++;
            l++; r--;
        }
        return (N%2==0 && count==1) || (N%2!=0 && count<=1) ? "YES" : "NO";
    }
}
