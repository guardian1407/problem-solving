package com.guardian.problemsolving.scaler.arrays;

import java.util.Arrays;

public class AddOneToNumber {
    public static void main(String[] args) {
        int[] A={0,0,0,9,2};
        Arrays.stream(plusOne(A)).forEach(e->System.out.print(e+" "));
    }
    private static int[] plusOne(int[] A){
        int N=A.length;
        int k=0;

        while(A[k]==0){
            if(k==N-1)
                break;
            else
                k++;
        }

        if(A[k]==0){
            int[] ans=new int[1];
            ans[0]=1;
            return ans;
        }
        else{
            int[] ans=new int[N-k];

            for(int i=k;i<N;i++)
                ans[i-k]=A[i];

            for(int i=N-1;i>=k;i--){
                if(A[i]!=9){
                    ans[i-k]=++A[i];
                    break;
                }
                else
                    ans[i-k]=0;
            }

            if(ans[0]==0){
                ans=new int[N-k+1];
                ans[0]=1;
            }
            return ans;
        }
    }
    static int[] plusOne1(int[] A) {
        int carry=1;
        int i=A.length-1;

        while(carry>0 && i>=0){
            int sum=A[i]+carry;
            if(sum>=10)
                A[i]=sum%10;
            else{
                A[i]=sum;
                carry=0;
            }
            i--;
        }

        if(i>=0){
            int mostSignificantIndex=0;
            while(mostSignificantIndex<A.length && A[mostSignificantIndex]==0)
                mostSignificantIndex++;
            if(mostSignificantIndex==0)
                return A;
            else{
                int[] B=new int[A.length-mostSignificantIndex];
                for(int x=mostSignificantIndex,y=0;x<A.length;x++,y++){
                    B[y]=A[x];
                }
                return B;
            }
        }
        else{
            if(carry==0)
                return A;
            else{
                int[] B=new int[A.length+1];
                B[0]=1;
                for(int x=0,y=1;x<A.length;x++,y++){
                    B[y]=A[x];
                }
                return B;
            }
        }
    }
}
