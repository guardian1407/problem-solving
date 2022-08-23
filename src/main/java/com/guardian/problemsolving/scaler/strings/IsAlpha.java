package com.guardian.problemsolving.scaler.strings;

public class IsAlpha {
    public static void main(String[] args) {
        char[] A= {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y'};
        char[] B= {'S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'};
        System.out.print(solve(B));
    }
    static int solve(char[] A) {
        for(int i=0;i<A.length-1;i++){
            if(!((A[i]>='a' && A[i]<='z') || (A[i]>='A' && A[i]<='Z')))
                return 0;
        }
        return 1;
    }
}
