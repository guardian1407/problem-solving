package com.guardian.problemsolving.scaler.greedyalgorithm;

import java.util.*;

public class AssignMiceToHoles {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(-4, 2, 3));
        ArrayList<Integer> B=new ArrayList<>(Arrays.asList(0, -2, 4));
        System.out.print(mice(A,B));
    }
    private static int mice(ArrayList<Integer> A, ArrayList<Integer> B){
        if (A.size() != B.size())
            return -1;

        /* Sort the lists */
        Collections.sort(A);
        Collections.sort(B);

        int size = A.size();

        /* finding max difference between ith mice and hole */
        int max = 0;
        for (int i=0; i<size; i++)
            if (max < Math.abs(A.get(i)-B.get(i)))
                max = Math.abs(A.get(i)-B.get(i));

        return Math.abs(max);
    }
}
