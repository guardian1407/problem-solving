package com.guardian.problemsolving.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class SortTheMatrixDiagonally {
    public static void main(String[] args) {
        int[][] mat={{75,21,13,24,8},{24,100,40,49,62}};
        for (int[] r : diagonalSort(mat)) {
            Stream.of(r).forEach(e -> System.out.print(Arrays.toString(e) + " "));
            System.out.println();
        }
    }
    public static int[][] diagonalSort(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        for(int k=0;k<n;k++){
            List<Integer> diagonal=new ArrayList<>();
            int i=k,j=0;
            while(i<n && j<m){
                diagonal.add(mat[i++][j++]);
            }
            Collections.sort(diagonal);
            i=k;j=0;
            for(int d:diagonal){
                mat[i++][j++]=d;
            }
        }
        for(int k=1;k<m;k++){
            List<Integer> diagonal=new ArrayList<>();
            int i=0,j=k;
            while(i<n && j<m){
                diagonal.add(mat[i++][j++]);
            }
            Collections.sort(diagonal);
            i=0;j=k;
            for(int d:diagonal){
                mat[i++][j++]=d;
            }
        }
        return mat;
    }
}
