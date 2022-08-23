package com.guardian.problemsolving.scaler.hashing;

import java.util.ArrayList;
import java.util.Arrays;

public class CommonElements {
    public static void main(String[] args) {
        ArrayList<Integer> A= new ArrayList<>(Arrays.asList(0, -8, 7, 2, 11, 11, 22));
        ArrayList<Integer> B= new ArrayList<>(Arrays.asList(5, 5, 7, 15, 11, 11, 27));
        solve(A,B).forEach(i->System.out.print(i+" "));
    }
    static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int[] sortedA=A.stream().mapToInt(i->i).sorted().toArray();
        int[] sortedB=B.stream().mapToInt(i->i).sorted().toArray();
        ArrayList<Integer> C=new ArrayList<>();
        int i=0;
        int j=0;

        while(i<sortedA.length && j<sortedB.length){
            int valA=sortedA[i];
            int valB=sortedB[j];

            if(valA<valB)
                i++;
            else if(valB<valA)
                j++;
            else{
                C.add(valA);
                i++;
                j++;
            }
        }
        return C;
    }
}
