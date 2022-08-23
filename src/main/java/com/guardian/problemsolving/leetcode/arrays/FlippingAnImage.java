package com.guardian.problemsolving.leetcode.arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlippingAnImage {
    public static void main(String[] args) {
        int[][] image={{1,1,0},{1,0,1},{0,0,0}};
        for (int[] r : flipAndInvertImage(image)) {
            Stream.of(r).forEach(e -> System.out.print(Arrays.toString(e) + " "));
            System.out.println();
        }
    }
    public static int[][] flipAndInvertImage(int[][] image) {
        for(int[] row : image){
            int l=0, r=image.length-1;
            while(l<=r){
                swap(row,l,r);
                invert(row,l);
                if(l!=r)
                    invert(row,r);
                l++; r--;
            }
        }
        return image;
    }
    public static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void invert(int[] arr, int i){
        arr[i]=arr[i]==0 ? 1 : 0;
    }
}
