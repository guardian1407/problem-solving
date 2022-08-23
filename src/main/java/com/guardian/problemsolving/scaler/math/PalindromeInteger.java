package com.guardian.problemsolving.scaler.math;

public class PalindromeInteger {
    public static void main(String[] args) {
        int A=123;
        System.out.print(isPalindrome(A));
    }
    static int isPalindrome(int A) {
        if(A<0) return 0;
        int org=A;
        int rev=0;

        while(A>0){
            rev=rev*10+A%10;
            A/=10;
        }
        return org==rev ? 1 : 0;
    }
}
