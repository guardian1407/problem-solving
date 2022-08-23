package com.guardian.problemsolving.scaler.math;

import java.util.ArrayList;

public class RearrangeArray {
    public static void main(String[] args){
        ArrayList<Integer> a=new ArrayList<>();
        a.add(4);
        a.add(0);
        a.add(2);
        a.add(1);
        a.add(3);
        arrange(a);
        a.forEach(i->System.out.print(i+" "));
    }
    private static void arrange(ArrayList<Integer> a){
        ArrayList<Integer> b=new ArrayList<>();

        for(int i=0;i<a.size();i++)
            b.add(a.get(a.get(i)));

        for(int i=0;i<b.size();i++)
            a.set(i,b.get(i));
    }
}
