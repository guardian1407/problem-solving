package com.guardian.problemsolving.scaler.strings;

public class ToLower {
    public static void main(String[] args) {
        char[] A= {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y'};
        char[] B= {'S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0'};
        System.out.print(to_lower(B));
    }
    static char[] to_lower(char[] A){
        for(int i=0;i<A.length;i++){
            if(A[i]>='A' && A[i]<='Z')
                A[i]=Character.toLowerCase(A[i]);
        }
        return A;
    }
}
