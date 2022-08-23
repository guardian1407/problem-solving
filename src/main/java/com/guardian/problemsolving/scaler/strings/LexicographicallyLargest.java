package com.guardian.problemsolving.scaler.strings;

import java.util.Arrays;

public class LexicographicallyLargest {
    public static void main(String[] args) {
        String A="abb_c";
        System.out.println(getLargest(A));
    }
    private static String getLargest(String A) {
        String[] input=A.split("_");
        String S=input[0];
        String T=input[1];
        char[] arr=T.toCharArray();
        Arrays.sort(arr);
        T=new StringBuilder(new String(arr)).reverse().toString();
        int i=0,j=0;
        StringBuilder sb=new StringBuilder();

        while(i<S.length() && j<T.length()){
            if(S.charAt(i)<T.charAt(j)){
                sb.append(T.charAt(j));
                j++;
            }
            else
                sb.append(S.charAt(i));
            i++;
        }
        while(i<S.length()){
            sb.append(S.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
