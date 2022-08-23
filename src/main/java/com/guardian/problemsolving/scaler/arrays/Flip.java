package com.guardian.problemsolving.scaler.arrays;

import java.util.ArrayList;

//Based on Kadane's algorithm
public class Flip {
    public static void main(String[] args) {
        String A="010";
        flip(A).forEach(e->System.out.print(e+" "));
    }
    private static ArrayList<Integer> flip(String A) {
        ArrayList<Integer> result = new ArrayList<Integer> ();

        if (A.length() == 0) return result;

        int [] m = new int [ A.length()];

        char [] chars = A.toCharArray();
        int numOnes =0;
        for ( int i=0;i<chars.length;i++ ){
            m[i] = chars[i]=='0'?1:-1;
            numOnes += m[i];
        }

        if ( numOnes == -m.length) return result;

        //Now, Kadane's.
        int leftLimitForThisBestSum=0;
        int rightLimitForThisBestSum=0;
        int thisBestSum = m[0];
        int prevBestSum = m[0];

        int leftLimitOfBestSum =0;
        int rightLimitOfBestSum =0;
        int bestSum = m[0];

        for ( int i = 1; i < m.length; i++ ){
            int prevPlusThisNum=m[i]+prevBestSum;
            if ( m[i] > prevPlusThisNum){
                leftLimitForThisBestSum=i;
                rightLimitForThisBestSum=i;
                thisBestSum=m[i];
            }
            else {
                rightLimitForThisBestSum=i;
                thisBestSum=prevPlusThisNum;
            }

            if ( thisBestSum > bestSum){
                bestSum=thisBestSum;
                leftLimitOfBestSum  = leftLimitForThisBestSum;
                rightLimitOfBestSum = rightLimitForThisBestSum;
            }
            prevBestSum=thisBestSum;
        }

        result.add(leftLimitOfBestSum+1);
        result.add(rightLimitOfBestSum+1);
        return result;
    }
}
