package com.guardian.problemsolving.scaler.recursion;

public class CheckPalindrome {
    public static void main(String[] args) {
        String A="abaa";
        System.out.print(solve(A));
    }
    static int solve(String A) {
        return isPalindrome(A,0,A.length()-1);
    }
    static int isPalindrome(String A,int s,int e){
        if (s == e)
            return 1;
        if ((A.charAt(s)) != (A.charAt(e)))
            return 0;
        if (s+1<e)
            return isPalindrome(A, s + 1, e - 1);
        return 1;
    }
}
