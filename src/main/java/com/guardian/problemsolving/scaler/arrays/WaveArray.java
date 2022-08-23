package com.guardian.problemsolving.scaler.arrays;

import java.util.Arrays;

public class WaveArray {
    public static void main(String[] args) {
        int[] A={1, 2, 3, 4};
        Arrays.stream(wave(A)).forEach(e->System.out.print(e+" "));
    }
    private static int[] wave(int[] A) {
        Arrays.sort(A);
        int i=0,j=1;
        while(i<A.length && j<A.length){
            swap(A,i,j);
            i+=2;
            j+=2;
        }
        return A;
    }
    private static void swap(int[] A,int i,int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
}
