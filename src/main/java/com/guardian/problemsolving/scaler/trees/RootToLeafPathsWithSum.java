package com.guardian.problemsolving.scaler.trees;

import java.util.ArrayList;

public class RootToLeafPathsWithSum {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(5);
        A.left=new TreeNode(4);
        A.right=new TreeNode(8);
        A.left.left=new TreeNode(11);
        A.right.left=new TreeNode(13);
        A.right.right=new TreeNode(4);
        A.left.left.left=new TreeNode(7);
        A.left.left.right=new TreeNode(2);
        A.right.right.left=new TreeNode(5);
        A.right.right.right=new TreeNode(1);
        int B=22;

        pathSum(A,B).forEach(list->{
            list.forEach(node->System.out.print(node+" "));
            System.out.println();
        });
    }
    private static ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B){
        return getAllPaths(A,B,new ArrayList<>());
    }
    private static ArrayList<ArrayList<Integer>> getAllPaths(TreeNode node,int sum,ArrayList<Integer> trail){
        if(node==null)
            return new ArrayList<>();

        sum-=node.val;
        trail.add(node.val);

        if(node.left==null && node.right==null){
            ArrayList<ArrayList<Integer>> paths=new ArrayList<>();

            if(sum==0)
                paths.add(trail);
            return paths;
        }
        else{
            ArrayList<ArrayList<Integer>> lst=getAllPaths(node.left,sum,new ArrayList<>(trail));
            ArrayList<ArrayList<Integer>> rst=getAllPaths(node.right,sum,new ArrayList<>(trail));
            lst.addAll(rst);
            return lst;
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
