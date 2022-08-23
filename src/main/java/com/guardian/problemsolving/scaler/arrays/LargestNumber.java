package com.guardian.problemsolving.scaler.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        int[] A={3, 30, 34, 5, 9};
        System.out.print(largestNumber(A));
    }
    private static String largestNumber(final int[] A){
        int N=A.length;
        String[] S=new String[N];

        for(int i=0;i<N;i++)
            S[i]=String.valueOf(A[i]);

        Comparator<String> C=
                (String str1, String str2)->{
                    String s1 = str1 + str2;
                    String s2 = str2 + str1;
                    return s2.compareTo(s1); // in reverse order
                };

        Arrays.sort(S,C);

        if(S[0].charAt(0)=='0')
            return "0";

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<N;i++)
            sb.append(S[i]);

        return sb.toString();
    }
}
