package com.guardian.problemsolving.scaler.arrays;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] A={1, 2, 3};
        Arrays.stream(nextPermutation(A)).forEach(e->System.out.print(e+" "));
    }
    private static int[] nextPermutation(int[] A) {
        if(A == null || A.length <= 1) return A;
        int i = A.length - 2;
        while(i >= 0 && A[i] >= A[i + 1]) i--;
        if(i >= 0) {
            int j = A.length - 1;
            while(A[j] <= A[i]) j--;
            swap(A, i, j);
        }
        reverse(A, i + 1, A.length - 1);
        return A;
    }
    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    private static void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }
//    private static int[] nextPermutation(int[] A) {
//        int i = A.length - 2;
//        while(i >= 0 && A[i] >= A[i + 1]) i--; // Find 1st id i that breaks descending order
//        if(i >= 0) {                           // If not entirely descending
//            int j = A.length - 1;              // Start from the end
//            while(A[j] <= A[i]) j--;           // Find rightmost first larger id j
//            swap(A, i, j);                     // Switch i and j
//        }
//        reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
//        return A;
//    }
}
