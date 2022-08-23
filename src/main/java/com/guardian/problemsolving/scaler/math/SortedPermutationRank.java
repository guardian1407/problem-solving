package com.guardian.problemsolving.scaler.math;

import java.math.BigInteger;

public class SortedPermutationRank {
    public static void main(String[] args) {
        String A="abmkloifg";
        System.out.print(findRank(A));
    }
    static int findRank(String A) {
        BigInteger rank=BigInteger.ONE;
        for(int i=0;i<A.length();i++){
            long less=0;

            for(int j=i+1;j<A.length();j++)
                if(A.charAt(j)<A.charAt(i)) less++;

            BigInteger factorial=factorial(A.length()-i-1);
            rank=rank.add(factorial.multiply(BigInteger.valueOf(less)));
        }
        return rank.remainder(BigInteger.valueOf(1000003)).intValue();
    }
    static BigInteger factorial(int A){
        if(A==0)
            return BigInteger.ONE;
        else return BigInteger.valueOf(A).multiply(factorial(A-1));
    }
}
