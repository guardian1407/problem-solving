package com.guardian.problemsolving.scaler.trees;

import java.util.ArrayList;

public class PrintAllRootToLeafPaths {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(5);
        A.left=new TreeNode(4);
        A.right=new TreeNode(8);
        A.left.left=new TreeNode(11);
        A.right.left=new TreeNode(13);
        A.right.right=new TreeNode(4);
        A.left.left.left=new TreeNode(7);
        A.right.right.left=new TreeNode(5);

        solve(A).forEach(list->{
            list.forEach(node->System.out.print(node+" "));
            System.out.println();
        });
    }
    private static ArrayList<ArrayList<Integer>> solve(TreeNode A){
        return getAllPaths(A,new ArrayList<>());
    }
    private static ArrayList<ArrayList<Integer>> getAllPaths(TreeNode node,ArrayList<Integer> trail){
        if(node==null)
            return new ArrayList<>();
        else{
            trail.add(node.val);
            ArrayList<ArrayList<Integer>> lst=getAllPaths(node.left,new ArrayList<>(trail));
            ArrayList<ArrayList<Integer>> rst=getAllPaths(node.right,new ArrayList<>(trail));
            lst.addAll(rst);

            if(lst.isEmpty())
                lst.add(trail);
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
