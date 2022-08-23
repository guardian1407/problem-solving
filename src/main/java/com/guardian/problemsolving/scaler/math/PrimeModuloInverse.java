package com.guardian.problemsolving.scaler.math;

public class PrimeModuloInverse {
    public static void main(String[] args) {
        int A=6;
        int B=23;
        modInverse(A,B);
        System.out.print(solve(A,B));
    }
    private static void modInverse(int a, int m)
    {
        int g = gcd(a, m);
        if (g != 1)
            System.out.println("Inverse doesn't exist");
        else
        {
            // If a and m are relatively prime, then modulo
            // inverse is a^(m-2) mode m
            System.out.println(
                    "Modular multiplicative inverse is "
                            + power(a, m - 2, m));
        }
    }
    private static int solve(int A, int B) {
        return power(A,B-2,B);
    }
    private static int power(int x, int y, int m) {
        if (y == 0)
            return 1;
        int p = power(x, y / 2, m) % m;
        p = (int)((p * (long)p) % m);
        if (y % 2 == 0)
            return p;
        else
            return (int)((x * (long)p) % m);
    }

    // Function to return gcd of a and b
    private static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}
