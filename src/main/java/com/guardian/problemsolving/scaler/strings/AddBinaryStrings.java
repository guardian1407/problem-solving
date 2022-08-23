package com.guardian.problemsolving.scaler.strings;

public class AddBinaryStrings {
    public static void main(String[] args){
        String A="110010";
        String B="100010";
        System.out.print(addBinary(A,B));
    }
    private static String addBinary(String A, String B){
        // Initialize result
        String result = "";

        // Initialize digit sum
        int s = 0;

        // Traverse both strings starting
        // from last characters
        int i = A.length() - 1, j = B.length() - 1;
        while (i >= 0 || j >= 0 || s == 1)
        {

            // Comput sum of last
            // digits and carry
            s += ((i >= 0)? A.charAt(i) - '0': 0);
            s += ((j >= 0)? B.charAt(j) - '0': 0);

            // If current digit sum is
            // 1 or 3, add 1 to result
            result = (char)(s % 2 + '0') + result;

            // Compute carry
            s /= 2;

            // Move to next digits
            i--; j--;
        }

        return result;
    }
    private static String addBinary1(String a, String b) {
        if(a == null || a.isEmpty())
            return b;
        if(b == null || b.isEmpty())
            return a;


        StringBuilder stb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int aBit;
        int bBit;
        int carry = 0;
        int result;

        while(i >= 0 || j >= 0 || carry == 1) {
            aBit = (i >= 0) ? Character.getNumericValue(a.charAt(i--)) : 0;
            bBit = (j >= 0) ? Character.getNumericValue(b.charAt(j--)) : 0;
            result = aBit ^ bBit ^ carry;
            carry = ((aBit + bBit + carry) >= 2) ? 1 : 0;
            stb.append(result);
        }
        return stb.reverse().toString();
    }
}
