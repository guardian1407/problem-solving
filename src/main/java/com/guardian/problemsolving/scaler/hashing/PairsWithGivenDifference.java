package com.guardian.problemsolving.scaler.hashing;

import java.util.*;

public class PairsWithGivenDifference {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(1, 2));
        int B=0;
        System.out.print(solve(A,B));
    }
    static int solve(ArrayList<Integer> A, int B) {
        Set<Integer> set=new HashSet<>(A);

        if(B==0 && set.size()==1)
            return 1;
        else if(B==0)
            return 0;
        else{
            int count=0;
            for(int i=0;i<A.size();i++){
                int e=A.get(i);
                if(set.contains(e)){
                    if(set.contains(e+B))
                        count++;
                    if(set.contains(e-B))
                        count++;
                    set.remove(e);
                }
            }
            return count;
        }
    }
}
