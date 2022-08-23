package com.guardian.problemsolving.scaler.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfSortedArrays {
    public static void main(String[] args) {
        List<Integer> A=new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 5, 6));
        List<Integer> B=new ArrayList<>(Arrays.asList(3, 3, 5));
        intersect(A,B).forEach(e->System.out.print(e+" "));
    }
    private static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0;
        int j=0;

        while(i<A.size() && j<B.size()){
            int e1=A.get(i);
            int e2=B.get(j);

            if(e1==e2){
                ans.add(e1);
                i++; j++;
            }
            else if(e1<e2)
                i++;
            else
                j++;
        }
        return ans;
    }
}
