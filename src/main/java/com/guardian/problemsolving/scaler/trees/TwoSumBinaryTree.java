package com.guardian.problemsolving.scaler.trees;

import java.util.HashSet;
import java.util.Set;

public class TwoSumBinaryTree {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(10);
        A.left=new TreeNode(9);
        A.right=new TreeNode(20);
        int B=19;

        System.out.print(t2Sum(A,B));
    }
    private static int t2Sum(TreeNode A, int B){
        Set<Integer> set=new HashSet<>();
        return t2Sum(A,B,set) ? 1 : 0;
    }
    private static boolean t2Sum(TreeNode node,int sum,Set<Integer> set){
        if(node==null)
            return false;

        int nodeVal=node.val;

        if(nodeVal>=sum)
            return t2Sum(node.left,sum,set);
        else{
            if(set.contains(sum-nodeVal))
                return true;
            else{
                set.add(nodeVal);
                return t2Sum(node.left,sum,set) || t2Sum(node.right,sum,set);
            }
        }
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }
}
