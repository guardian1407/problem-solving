package com.guardian.problemsolving.leetcode.backtracking;

import java.util.*;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates={10,1,2,7,6,1,5};
        int target=8;
        combinationSum2(candidates,target).forEach(list->{
            list.forEach(i-> System.out.print(i+" "));
            System.out.println();
        });
    }
    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res=new HashSet<>();
        combinationSum2(candidates,target,0,new ArrayList<>(),new HashSet<>(),res);
        return new ArrayList<>(res);
    }
    private static void combinationSum2(int[] candidates, int target, int sum, List<Integer> list, Set<Integer> indexSet, Set<List<Integer>> res) {
        for(int i=0;i<candidates.length;i++){
            int val=candidates[i];
            List<Integer> copyList;
            if(sum+val<target && !indexSet.contains(i)){
                copyList=new ArrayList<>(list);
                copyList.add(val);
                Set<Integer> copyIndexSet=new HashSet<>(indexSet);
                copyIndexSet.add(i);
                combinationSum2(candidates,target,sum+val,copyList,copyIndexSet,res);
            }
            else if(sum+val==target && !indexSet.contains(i)){
                copyList=new ArrayList<>(list);
                copyList.add(val);
                Collections.sort(copyList);
                res.add(copyList);
            }
        }
    }
}
