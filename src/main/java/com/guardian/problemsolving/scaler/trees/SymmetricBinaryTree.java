package com.guardian.problemsolving.scaler.trees;

public class SymmetricBinaryTree {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(1);
        A.left=new TreeNode(2);
        A.right=new TreeNode(2);
        A.left.left=new TreeNode(3);
        A.left.right=new TreeNode(4);
        A.right.left=new TreeNode(4);
        A.right.right=new TreeNode(3);

        System.out.print(isSymmetric(A));
    }
    private static int isSymmetric(TreeNode A){
        return (A==null || isSymmetricHelp(A.left, A.right)) ? 1 : 0;
    }
    private static boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
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
