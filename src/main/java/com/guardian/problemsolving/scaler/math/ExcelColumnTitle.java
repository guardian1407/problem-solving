package com.guardian.problemsolving.scaler.math;

public class ExcelColumnTitle {
    public static void main(String[] args) {
        int A=943566;
        System.out.println(convertToTitle(A));
    }
    private static String convertToTitle(int A) {
        StringBuilder stringBuilder=new StringBuilder();
        while(A>0){
            if(A%26==0){
                stringBuilder.append('Z');
                A=A/26-1;
            }
            else{
                stringBuilder.append((char)('A'+A%26-1));
                A/=26;
            }
        }
        return stringBuilder.reverse().toString();
    }
}
