package com.guardian.problemsolving.scaler.math;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class SortedPermutationRankWithRepeats {
    public static void main(String[] args) {
        String A="asasdsdsadasdadsadasdsa";
        System.out.print(findRank(A));
    }
    static int findRank(String A) {
        BigInteger rank=BigInteger.ONE;
        for(int i=0;i<A.length();i++){
            long less=0;
            BigInteger denom=BigInteger.ONE;
            Map<Character,Integer> hm=new HashMap<>();

            for(int j=i+1;j<A.length();j++)
                if(A.charAt(j)<A.charAt(i)) less++;

            for(int j=i;j<A.length();j++){
                Integer count=hm.containsKey(A.charAt(j)) ? hm.get(A.charAt(j))+1 : 1;
                hm.put(A.charAt(j),count);
            }

            for (Map.Entry entry : hm.entrySet())
                denom=denom.multiply(factorial((int)entry.getValue()));

            BigInteger factorial=factorial(A.length()-i-1);
            rank=rank.add(factorial.multiply(BigInteger.valueOf(less)).divide(denom));
        }
        return rank.remainder(BigInteger.valueOf(1000003)).intValue();
    }
    static BigInteger factorial(int A){
        if(A==0)
            return BigInteger.ONE;
        else return BigInteger.valueOf(A).multiply(factorial(A-1));
    }
}
