package com.guardian.problemsolving.scaler.strings;

public class AmazingSubarrays {
    public static void main(String[] args){
        String A="ABEC";
        System.out.print(solve(A));
    }
    private static int solve(String A){
        int MOD=10003;
        int N=A.length();
        int count=0;

        for (int i=0;i<N;i++){
            if (isVowel(A.charAt(i)))
                count+=N-i;
        }
        return count%MOD;
    }
    private static boolean isVowel(char A){
        boolean res;
        switch (A){
            case 'a':
            case 'A':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
            case 'o':
            case 'O':
            case 'u':
            case 'U':
                res = true;
                break;
            default:
                res = false;
                break;
        }
        return res;
    }
}
