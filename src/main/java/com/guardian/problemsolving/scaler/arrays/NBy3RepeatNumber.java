package com.guardian.problemsolving.scaler.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Based on Moore’s Voting algorithm
public class NBy3RepeatNumber {
    public static void main(String[] args) {
        List<Integer> a=new ArrayList<>(Arrays.asList(1, 2, 3, 1, 1));
        System.out.print(repeatedNumber(a));
    }
    private static int repeatedNumber(final List<Integer> a) {
        int n=a.size();
        int count1=0,count2=0;
        Integer first=null;
        Integer second=null;

        for(int i=0;i<n;i++){
            if (first!=null && first.equals(a.get(i)))
                count1++;
            else if(second!=null && second.equals(a.get(i)))
                count2++;
            else if(first==null || count1==0){
                count1++;
                first=a.get(i);
            }
            else if(second==null || count2==0){
                count2++;
                second=a.get(i);
            }
            else{
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;
        for(int i=0;i<n;i++){
            if(first!=null && first.equals(a.get(i)))
                count1++;
            else if(second!=null && second.equals(a.get(i)))
                count2++;
        }

        if(count1>n/3)
            return first;
        if(count2>n/3)
            return second;
        return -1;
    }
}
