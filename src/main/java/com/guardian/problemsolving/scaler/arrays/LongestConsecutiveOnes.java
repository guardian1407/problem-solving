package com.guardian.problemsolving.scaler.arrays;

public class LongestConsecutiveOnes {
    public static void main(String[] args) {
        String A="110100";
        System.out.print(solve(A));
    }
    static int solve(String A) {
        if(A.length()==1 && A.charAt(0)=='1')
            return 1;
        else if(A.length()==1 && A.charAt(0)=='0')
            return 0;
        else{
            int[] left=new int[A.length()];
            int[] right=new int[A.length()];
            int countOne=0;
            int longestSub=0;

            for(int i=0;i<A.length();i++){
                if(i==0 && A.charAt(i)=='1'){
                    left[i] = 1;
                    countOne++;
                }
                else if(A.charAt(i)=='0')
                    left[i]=0;
                else{
                    left[i]=left[i-1]+1;
                    countOne++;
                }
            }

            for(int i=A.length()-1;i>=0;i--){
                if(i==A.length()-1 && A.charAt(i)=='1')
                    right[i]=1;
                else if(A.charAt(i)=='0')
                    right[i]=0;
                else
                    right[i]=right[i+1]+1;
            }

            for(int i=0;i<A.length();i++){
                if(i==0 && A.charAt(i)=='1')
                    longestSub=Math.max(longestSub,right[i]);
                else if(i==A.length()-1 && A.charAt(i)=='1')
                    longestSub=Math.max(longestSub,left[i]);
                else if(A.charAt(i)=='1')
                    longestSub=Math.max(longestSub,left[i]+right[i]-1);
                else if(i==0 && A.charAt(i)=='0')
                    longestSub=right[i+1]+1<=countOne ? Math.max(longestSub,right[i+1]+1) : Math.max(longestSub,right[i+1]);
                else if(i==A.length()-1 && A.charAt(i)=='0')
                    longestSub=left[i-1]+1<=countOne ? Math.max(longestSub,left[i-1]+1) : Math.max(longestSub,left[i-1]);
                else if(A.charAt(i)=='0')
                    longestSub=left[i-1]+right[i+1]+1<=countOne ? Math.max(longestSub,left[i-1]+right[i+1]+1) : Math.max(longestSub,left[i-1]+right[i+1]);
            }
            return longestSub;
        }
    }
}
