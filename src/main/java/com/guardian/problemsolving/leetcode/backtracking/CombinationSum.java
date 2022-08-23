package com.guardian.problemsolving.leetcode.backtracking;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates={1,2,7,6,3,5};
        int target=9;
        combinationSum(candidates,target).forEach(list->{
            list.forEach(i-> System.out.print(i+" "));
            System.out.println();
        });
    }
    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> res=new HashSet<>();
        combinationSum(candidates,target,0,new ArrayList<>(),res);
        return new ArrayList<>(res);
    }
    private static void combinationSum(int[] candidates, int target, int sum, List<Integer> list, Set<List<Integer>> res) {
        for(int i:candidates){
            List<Integer> copyList;
            if(sum+i<target){
                copyList=new ArrayList<>(list);
                copyList.add(i);
                combinationSum(candidates,target,sum+i,copyList,res);
            }
            else if(sum+i==target){
                copyList=new ArrayList<>(list);
                copyList.add(i);
                Collections.sort(copyList);
                res.add(copyList);
            }
        }
    }
}
