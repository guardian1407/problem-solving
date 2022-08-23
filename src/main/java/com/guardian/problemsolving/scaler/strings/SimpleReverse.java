package com.guardian.problemsolving.scaler.strings;

public class SimpleReverse {
    public static void main(String[] args) {
        String A = "ravish";
        System.out.print(solve(A));
    }
    static String solve(String A) {
//        String reverse = "";
//        for(int i=A.length()-1;i>=0;i--)
//            reverse+=A.charAt(i);
//        return reverse;
        return new StringBuffer(A).reverse().toString();
    }
}
