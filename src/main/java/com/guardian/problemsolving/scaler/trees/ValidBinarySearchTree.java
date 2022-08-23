package com.guardian.problemsolving.scaler.trees;

public class ValidBinarySearchTree {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(2);
        A.left=new TreeNode(1);
        A.right=new TreeNode(3);

        System.out.print(isValidBST(A));
    }
    private static int isValidBST(TreeNode A){
        return isValidBST(A,Long.MIN_VALUE,Long.MAX_VALUE) ? 1 : 0;
    }
    public static boolean isValidBST(TreeNode root,long minVal,long maxVal){
        if(root==null)
            return true;

        if(root.val>=maxVal || root.val<=minVal)
            return false;

        return isValidBST(root.left,minVal,root.val) && isValidBST(root.right,root.val,maxVal);
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
