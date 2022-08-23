package com.guardian.problemsolving.scaler.trees;

import java.util.ArrayList;

public class BoundaryTraversalOfBinaryTree {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(1);
        A.left=new TreeNode(2);
        A.right=new TreeNode(3);
        A.left.left=new TreeNode(4);
        A.left.right=new TreeNode(5);
        A.right.left=new TreeNode(6);
        A.left.right.left=new TreeNode(7);
        A.left.right.right=new TreeNode(8);
        A.right.left.left=new TreeNode(9);
        A.right.left.right=new TreeNode(10);

        solve(A).forEach(node->System.out.print(node+" "));
    }
    private static ArrayList<Integer> solve(TreeNode A){
        ArrayList<Integer> ans=new ArrayList<>();
        if(A==null)
            return ans;

        ans.add(A.val);
        if(A.left==null && A.right==null)
            return ans;

        ArrayList<Integer> leftInternal=getLeftInternalNodesTopDown(A.left,new ArrayList<>());
        ArrayList<Integer> leaves=getLeafNodes(A,new ArrayList<>());
        ArrayList<Integer> rightInternal=getRightInternalNodesBottomUp(A.right,new ArrayList<>());

        ans.addAll(leftInternal);
        ans.addAll(leaves);
        ans.addAll(rightInternal);

        return ans;
    }
    private static ArrayList<Integer> getLeftInternalNodesTopDown(TreeNode node,ArrayList<Integer> list){
        if(node==null || (node.left==null && node.right==null))
            return list;
        else if(node.left!=null){
            list.add(node.val);
            return getLeftInternalNodesTopDown(node.left,list);
        }
        else{
            list.add(node.val);
            return getLeftInternalNodesTopDown(node.right,list);
        }
    }
    private static ArrayList<Integer> getRightInternalNodesBottomUp(TreeNode node,ArrayList<Integer> list){
        if(node==null || (node.left==null && node.right==null))
            return list;
        else if(node.right!=null){
            getRightInternalNodesBottomUp(node.right,list);
            list.add(node.val);
            return list;
        }
        else{
            getRightInternalNodesBottomUp(node.left,list);
            list.add(node.val);
            return list;
        }
    }
    private static ArrayList<Integer> getLeafNodes(TreeNode node,ArrayList<Integer> list){
        if(node==null)
            return list;

        if(node.left==null && node.right==null){
            list.add(node.val);
            return list;
        }
        getLeafNodes(node.left,list);
        getLeafNodes(node.right,list);

        return list;
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
