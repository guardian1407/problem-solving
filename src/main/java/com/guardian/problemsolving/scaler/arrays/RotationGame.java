package com.guardian.problemsolving.scaler.arrays;

import java.util.Scanner;

public class RotationGame {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        sc.nextLine();

        while(T>0){
            String input=sc.nextLine();
            String[] elements=input.split("\\s+");
            int size=Integer.parseInt(elements[0]);
            int[] A=new int[size];

            if(size==elements.length-1){
                for(int i=1; i<elements.length; i++){
                    A[i-1]=Integer.parseInt(elements[i]);
                }
            }
            int B=sc.nextInt();
            solve(A,B);

            for(int i=0; i<A.length; i++)
                System.out.print(A[i]+" ");

            System.out.println();
            T--;
            sc.nextLine();
        }
    }
    static void solve(int[] A, int B) {
        B%=A.length;
        swap(A, 0, A.length-1);
        swap(A, 0, B-1);
        swap(A, B, A.length-1);
    }

    static void swap(int[] A, int l, int r){
        while (l < r){
            int temp=A[l];
            A[l]=A[r];
            A[r]=temp;
            l++;
            r--;
        }
    }
}



