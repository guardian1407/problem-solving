package com.guardian.problemsolving.scaler.binarysearch;

public class SquareRootOfInteger {
    public static void main(String[] args) {
        int A=930675566;
        System.out.println(sqrt(A));
    }
    private static int sqrt(int A) {
        long l=1;
        long r=A;

        while(r-l>1){
            long mid=l+(r-l)/2;
            if(mid*mid>A)
                r=mid-1;
            else if(mid*mid<A)
                l=mid;
            else
                return (int)mid;
        }
        long ans=r*r>A ? l :r;
        return (int)ans;
    }
}
