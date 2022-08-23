package com.guardian.problemsolving.scaler.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3));
        solve(A).forEach(e->System.out.print(e+" "));
    }
    private static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> ans=new ArrayList<>();
        int p=-1;
        int i=0;

        while(i<A.size()){
            if(p<0 || !A.get(i).equals(A.get(p)))
                ans.add(A.get(i));
            i++;p++;
        }
        return ans;
    }
}
