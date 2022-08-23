package com.guardian.problemsolving.scaler.hashing;

import java.util.*;

public class PerfectCards {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(1, 1, 2, 2));
        System.out.print(solve(A));
    }
    private static String solve(ArrayList<Integer> A) {
        String ans="LOSE";
        Map<Integer,Integer> map=new HashMap<>();
        A.forEach(e->{
            int count=map.containsKey(e) ? map.get(e)+1 : 1;
            map.put(e,count);
        });
        if(map.size()==2){
            List<Integer> values=new ArrayList<>(map.values());
            if(Objects.equals(values.get(0),values.get(1)))
                ans="WIN";
        }
        return ans;
    }
}
