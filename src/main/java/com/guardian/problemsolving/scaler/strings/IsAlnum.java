package com.guardian.problemsolving.scaler.strings;

public class IsAlnum {
    public static void main(String[] args) {
        char[] A= {'S', 'c', 'a', '2', 'e', '1', 'A', 'c', 'a', 'd', '9', 'm', 'y'};
        char[] B= {'S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'};
        System.out.print(solve(B));
    }
    static int solve(char[] A) {
        for(int i=0;i<A.length-1;i++){
            if(!((A[i]>='a' && A[i]<='z') || (A[i]>='A' && A[i]<='Z') || (A[i]>='0' && A[i]<='9')))
                return 0;
        }
        return 1;
    }
}
