package com.guardian.problemsolving.scaler.math;

public class ExcelColumnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("ABCD"));
    }
    static int titleToNumber(String A) {
        int val = 0;
        for(int i=0;i<A.length();i++){
            val *= 26;
            val += A.charAt(i)-'A'+1;
        }
        return val;
    }
}


