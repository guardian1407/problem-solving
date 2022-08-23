package com.guardian.problemsolving.scaler.strings;

public class AddBinary {
    public static void main(String[] args) {
        String a="100000111101";
        String b="101";
        System.out.print(addBinary(a,b));
    }
    static String addBinary(String a, String b) {
        String sumString="";
        int A=a.length()-1;
        int B=b.length()-1;
        String carry="0";

        while(A>=0 && B>=0){
            if(a.charAt(A)=='0' && b.charAt(B)=='0'){
                if("0".equalsIgnoreCase(carry))
                    sumString="0".concat(sumString);
                else{
                    sumString="1".concat(sumString);
                    carry="0";
                }
            }
            else if((a.charAt(A)=='0' && b.charAt(B)=='1') || (a.charAt(A)=='1' && b.charAt(B)=='0')){
                if("0".equalsIgnoreCase(carry))
                    sumString="1".concat(sumString);
                else {
                    sumString="0".concat(sumString);
                    carry="1";
                }
            }
            else {
                if("0".equalsIgnoreCase(carry)){
                    sumString="0".concat(sumString);
                    carry="1";
                }
                else {
                    sumString="1".concat(sumString);
                    carry="1";
                }
            }
            A--;
            B--;
        }

        if(A>=0)
            sumString = addRemaining(a,A,sumString,carry);
        else if(B>=0)
            sumString = addRemaining(b,B,sumString,carry);
        else if("1".equalsIgnoreCase(carry))
            sumString="1".concat(sumString);

        return sumString;
    }

    static String addRemaining(String a,int A,String sumString,String carry){
        while("1".equalsIgnoreCase(carry) && A>=0){
            if(a.charAt(A)=='0'){
                sumString="1".concat(sumString);
                carry="0";
            }
            else {
                sumString="0".concat(sumString);
                carry="1";
            }
            A--;
        }
        if(A>=0)
            sumString=a.substring(0,A+1).concat(sumString);
        else if("1".equalsIgnoreCase(carry))
            sumString="1".concat(sumString);

        return sumString;
    }
}
