package com.guardian.problemsolving.scaler.strings;

public class LongestCommonPrefix {
    public static void main(String[] args){
        String[] A={"abcdefgh", "aefghijk", "abcefgh"};
        System.out.print(longestCommonPrefix(A));
    }
    private static String longestCommonPrefix(String[] A){
        int N=A.length;
        String ans="";
        if(N==0) return ans;
        ans=A[0];

        for(int i=1;i<N;i++){
            int len=Math.min(ans.length(),A[i].length());
            int p=0;

            while(p<len){
                if(A[i].charAt(p)!=ans.charAt(p)) break;
                p++;
            }
            if(p==0) return "";
            ans=A[i].substring(0,p);
        }
        return ans;
    }
}
