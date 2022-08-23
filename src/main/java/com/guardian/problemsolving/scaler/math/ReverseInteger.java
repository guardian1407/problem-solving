package com.guardian.problemsolving.scaler.math;

public class ReverseInteger {
    public static void main(String[] args) {
        int A=-123;
        System.out.print(reverse(A));
    }
    private static int reverse(int A) {
        int num=Math.abs(A);
        int rev=0;
        int prev=0;

        while(num>0){
            rev=rev*10+num%10;
            if((rev-num%10)/10!=prev)
                return 0;
            num/=10;
            prev=rev;
        }
        return A<0 ? -rev : rev;
    }
}
