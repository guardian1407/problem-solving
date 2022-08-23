package com.guardian.problemsolving.scaler.hashing;

import java.util.HashMap;
import java.util.Map;

public class ReplicatingSubstring {
    public static void main(String[] args) {
        int A=2;
        String B="bbaabb";
        System.out.println(solve(A,B));
    }
    private static int solve(int A, String B) {
        Map<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<B.length();i++){
            char c=B.charAt(i);
            int val=hm.containsKey(c)?hm.get(c)+1:1;
            hm.put(c,val);
        }
        for(Map.Entry<Character,Integer> e:hm.entrySet()){
            int val=e.getValue();
            if(val%A!=0)
                return -1;
        }
        return 1;
    }
}
