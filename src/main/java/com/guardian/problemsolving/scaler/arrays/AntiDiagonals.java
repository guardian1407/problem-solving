package com.guardian.problemsolving.scaler.arrays;

import java.util.ArrayList;

public class AntiDiagonals {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        ArrayList<Integer> A1=new ArrayList<>();
        A1.add(1);
        A1.add(2);
        A1.add(3);
        A.add(A1);
        ArrayList<Integer> A2=new ArrayList<>();
        A2.add(4);
        A2.add(5);
        A2.add(6);
        A.add(A2);
        ArrayList<Integer> A3=new ArrayList<>();
        A3.add(7);
        A3.add(8);
        A3.add(9);
        A.add(A3);
        ArrayList<ArrayList<Integer>> B=diagonal(A);
        B.forEach(C->{
            C.forEach(I->System.out.print(I+" "));
            System.out.println(" ");
        });
    }
    private static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A){
        int N=A.size();
        ArrayList<ArrayList<Integer>> B=new ArrayList<>();
        for(int c=0;c<N;c++){
            ArrayList<Integer> diagonals=new ArrayList<>();
            int i=0; int j=c;
            while(i<N && j>=0){
                diagonals.add(A.get(i).get(j));
                i++; j--;
            }
            B.add(diagonals);
        }
        for(int r=1;r<N;r++){
            ArrayList<Integer> diagonals=new ArrayList<>();
            int i=r; int j=N-1;
            while(i<N && j>=r){
                diagonals.add(A.get(i).get(j));
                i++; j--;
            }
            B.add(diagonals);
        }
        return B;
    }
}
