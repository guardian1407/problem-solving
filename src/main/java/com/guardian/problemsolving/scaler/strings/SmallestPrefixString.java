package com.guardian.problemsolving.scaler.strings;

public class SmallestPrefixString {
    public static void main(String[] args) {
        String A="abba";
        String B="cdd";
        System.out.println(smallestPrefix(A,B));
    }
    private static String smallestPrefix(String A, String B) {
        int i=1;
        while(i<A.length() && A.charAt(i)<B.charAt(0))
            i++;
        return A.substring(0,i)+B.charAt(0);
    }
}
