package com.guardian.problemsolving.scaler.arrays;

import java.util.ArrayList;

public class PascalTriangle {
    public static void main(String[] args) {
        int A=0;
        ArrayList<ArrayList<Integer>> B=solve(A);
        B.forEach(C->{
            C.forEach(I->System.out.print(I+" "));
            System.out.println(" ");
        });
    }
    private static ArrayList<ArrayList<Integer>> solve(int A){
        ArrayList<ArrayList<Integer>> B=new ArrayList<>();
        if(A<=0) return B;
        ArrayList<Integer> firstRow=new ArrayList<>();
        firstRow.add(1);
        B.add(firstRow);

        for(int i=1;i<A;i++){
            ArrayList<Integer> prevRow=B.get(i-1);
            int prevSize=prevRow.size();
            ArrayList<Integer> row=new ArrayList<>();
            row.add(prevRow.get(0));

            for(int j=1;j<prevSize;j++)
                row.add(prevRow.get(j-1)+prevRow.get(j));

            row.add(prevRow.get(prevSize-1));
            B.add(row);
        }
        return B;
    }
}
