package com.guardian.problemsolving.scaler.hashing;

import java.util.*;

public class SortArrayInGivenOrder {
    public static void main(String[] args){
        ArrayList<Integer> A= new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> B= new ArrayList<>(Arrays.asList(5, 4, 2));
        solve(A,B).forEach(i->System.out.print(i+" "));
    }
    private static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B){
        int N1=A.size();
        int N2=B.size();
        int[] sortedA=A.stream().mapToInt(i->i).sorted().toArray();
        Map<Integer,Integer> hm=new HashMap<>();
        Set<Integer> hs=new HashSet<>();
        ArrayList<Integer> C=new ArrayList<>();

        for(int i=0;i<N1;i++){
            int val=sortedA[i];
            if(hm.containsKey(val))
                hm.put(val,hm.get(val)+1);
            else
                hm.put(val,1);
        }

        for(int i=0;i<N2;i++)
            hs.add(B.get(i));

        for(int i=0;i<N2;i++){
            int val=B.get(i);
            if(hm.containsKey(val)){
                int count=hm.get(val);
                for(int j=1;j<=count;j++)
                    C.add(val);
            }
        }

        for(int i=0;i<N1;i++){
            int val=sortedA[i];
            if(!hs.contains(val))
                C.add(val);
        }
        return C;
    }
}
