package com.guardian.problemsolving.scaler.strings;

public class StringOperations {
    public static void main(String[] args){
        String A="AbcaZeoB";
        System.out.print(solve(A));
    }
    private static String solve(String A){
        A=A.concat(A);
        int N=A.length();
        StringBuffer B=new StringBuffer();

        for(int i=0;i<N;i++){
            if(!(A.charAt(i)>='A' && A.charAt(i)<='Z')){
                if(A.charAt(i)=='a' || A.charAt(i)=='e' || A.charAt(i)=='i' || A.charAt(i)=='o' || A.charAt(i)=='u')
                    B.append("#");
                else
                    B.append(A.charAt(i));
            }
        }
        return B.toString();
    }
}
