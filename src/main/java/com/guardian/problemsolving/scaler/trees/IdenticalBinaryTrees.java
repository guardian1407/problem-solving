package com.guardian.problemsolving.scaler.trees;

public class IdenticalBinaryTrees {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(1);
        A.left=new TreeNode(2);
        A.right=new TreeNode(3);

        TreeNode B=new TreeNode(1);
        B.left=new TreeNode(3);
        B.right=new TreeNode(3);

        System.out.print(isSameTree(A,B));
    }
    private static int isSameTree(TreeNode A, TreeNode B){
        return isSameTreeHelper(A,B) ? 1 : 0;
    }
    private static boolean isSameTreeHelper(TreeNode A, TreeNode B){
        if(A==null || B==null)
            return A==B;
        if(A.val!=B.val)
            return false;
        return isSameTreeHelper(A.left,B.left) && isSameTreeHelper(A.right,B.right);
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
