package com.guardian.problemsolving.scaler.backtracking;

import java.util.Set;

public class Sudoku {
    public static void main(String[] args) {
        char[][] A={{'a'}};
        solveSudoku(A);
        for (char[] row : A) {
            for (char c : row){
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }
    private static void solveSudoku(char[][] A) {

    }
    private static void solveSudoku(char[][] A,Set<String> visited,int i, int j){
        if(A[i][j]!='.'){
            for(int k=1;k<=9;k++){
                String row=String.valueOf(k)+i;
                String col=String.valueOf(k)+j;
                String block=String.valueOf(k)+i/3+j/3;

                if(!visited.contains(row) && !visited.contains(col) && !visited.contains(block)){
                    visited.add(row);
                    visited.add(col);
                    visited.add(block);
                    next(A,visited,i,j);
                    visited.remove(row);
                    visited.remove(col);
                    visited.remove(block);
                }
            }
        }
    }
    private static void next(char[][] A,Set<String> visited,int i, int j){

    }
}
