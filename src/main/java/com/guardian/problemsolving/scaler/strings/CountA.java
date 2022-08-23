package com.guardian.problemsolving.scaler.strings;

public class CountA {
    public static void main(String[] args) {
        String A="aab";
        System.out.println(solve(A));
    }
    private static int solve(String A) {
        int count=0;

        for(int i=0;i<A.length();i++){
            if('a'==A.charAt(i))
                count++;
        }
        return (count*(count+1)/2);
    }
}
