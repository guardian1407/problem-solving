package com.guardian.problemsolving.scaler.strings;

public class ToUpper {
    public static void main(String[] args) {
        char[] A= {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y'};
        char[] B= {'S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0'};
        System.out.print(to_upper(B));
    }
    static char[] to_upper(char[] A){
        for(int i=0;i<A.length;i++){
            if(A[i]>='a' && A[i]<='z')
                A[i]=Character.toUpperCase(A[i]);
        }
        return A;
    }
}
