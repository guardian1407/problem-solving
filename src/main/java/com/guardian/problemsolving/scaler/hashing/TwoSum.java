package com.guardian.problemsolving.scaler.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {
        List<Integer> A= Arrays.asList(4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8);
        int B=-3;
        twoSum(A,B).forEach(i->System.out.print(i+" "));
    }
    static ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int index1=0;
        int index2=0;
        boolean flag=false;

        for(int j=0;j<A.size();j++){
            Integer key=A.get(j);
            Integer diff=B-key;
            Integer i=hashMap.get(diff);

            if(i!=null){
                flag=true;
                index1=++i;
                index2=j+1;
                break;
            }
            else if(hashMap.get(key)==null)
                hashMap.put(key,j);
        }
        return flag ? new ArrayList<>(Arrays.asList(index1,index2)) :new ArrayList<>();
    }
}
