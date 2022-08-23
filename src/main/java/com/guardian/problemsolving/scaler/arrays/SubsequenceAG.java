package com.guardian.problemsolving.scaler.arrays;

public class SubsequenceAG {
    public static void main(String[] args) {
        String A="JKDOSAJKGHJASAGGGGA";
        System.out.print(solve(A));
    }
    static long solve(String A) {
        long M = (long)1e9+7;
        int count=0;
        int countG=0;

        for(int i=A.length()-1;i>=0;i--){
            if(A.charAt(i)=='G')
                countG++;
            else if(A.charAt(i)=='A')
                count+=countG;
        }
        return count%M;
    }
}
