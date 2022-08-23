package com.guardian.problemsolving.scaler.math;

public class FizzBuzz {
    public static void main(String[] args) {
        int A=10;
        for (String s : fizzBuzz(A)) {
            System.out.println(s);
        }
    }
    private static String[] fizzBuzz(int A) {
        String[] strArr = new String[A];

        for (int i=0; i<A; i++){
            if((i+1)%3 == 0 && (i+1)%5 == 0)
                strArr[i] = "FizzBuzz";
            else if((i+1)%3 == 0)
                strArr[i] = "Fizz";
            else if((i+1)%5 == 0)
                strArr[i] = "Buzz";
            else
                strArr[i] = String.valueOf(i+1);
        }
        return  strArr;
    }
}

