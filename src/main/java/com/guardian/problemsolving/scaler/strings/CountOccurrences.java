package com.guardian.problemsolving.scaler.strings;

public class CountOccurrences {
    public static void main(String[] args){
        String A= "abobc";
        System.out.print(solve(A));
    }
    private static int solve(String A){
        int N=A.length();
        int count=0;

        for(int i=0;i<N;){
            if('b'==A.charAt(i) && i+3<=N && "bob".equals(A.substring(i,i+3))){
                i+=2;
                count++;
            }
            else
                i++;
        }
        return count;
    }
}
