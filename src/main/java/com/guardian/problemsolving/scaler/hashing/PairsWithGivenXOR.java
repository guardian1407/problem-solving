package com.guardian.problemsolving.scaler.hashing;

import java.util.HashMap;
import java.util.Map;

public class PairsWithGivenXOR {
    public static void main(String[] args) {
        int[] A={3, 6, 8, 10, 15, 50};
        int B=5;
        System.out.print(solve(A,B));
    }
    private static int solve(int[] A, int B) {
        Map<Integer,Integer> hm=new HashMap<>();
        int pairs=0;

        for(int i=0;i<A.length;i++){
            int xor=A[i]^B;
            Integer pairVal=hm.get(xor);

            if(pairVal!=null){
                if(pairVal==0){
                    pairs++;
                    hm.put(xor,1);
                    hm.put(A[i],1);
                }
            }
            else
                hm.put(A[i],0);
        }
        return pairs;
    }
}
