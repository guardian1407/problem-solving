package com.guardian.problemsolving.leetcode.arrays;

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(diagonalSum(mat));
    }
    public static int diagonalSum(int[][] mat) {
        int res=0;
        for(int i=0,j=0;i<mat.length && j<mat.length;i++,j++){
            res+=mat[i][j];
        }
        for(int i=0,j=mat.length-1;i<mat.length && j>=0;i++,j--){
            if(i!=j)
                res+=mat[i][j];
        }
        return res;
    }
}
