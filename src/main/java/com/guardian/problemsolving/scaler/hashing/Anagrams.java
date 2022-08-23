package com.guardian.problemsolving.scaler.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
    public static void main(String[] args) {
        List<String> A= Arrays.asList("cat", "dog", "god", "tca");
        ArrayList<ArrayList<Integer>> B=anagrams(A);

        for(int i=0; i<B.size(); i++){
            ArrayList<Integer> C=B.get(i);
            for(int j=0; j<C.size(); j++)
                System.out.print(C.get(j)+" ");
            System.out.println();
        }
    }
    static ArrayList<ArrayList<Integer>> anagrams(final List<String> A){
        HashMap<String,ArrayList<Integer>> hashMap=new HashMap<>();

        for(int i=0; i<A.size(); i++){
            String key=getKey(A.get(i));
            ArrayList<Integer> value=hashMap.get(key);

            if(value==null){
                value=new ArrayList<>();
                value.add(i+1);
                hashMap.put(key,value);
            }
            else
                value.add(i+1);
        }
        return new ArrayList<>(hashMap.values());
    }
    static String getKey(String A){
        char[] B = A.toCharArray();
        Arrays.sort(B);
        return new String(B);
    }
}
