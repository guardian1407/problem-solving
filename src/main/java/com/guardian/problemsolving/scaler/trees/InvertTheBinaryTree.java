package com.guardian.problemsolving.scaler.trees;

public class InvertTheBinaryTree {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(1);
        A.left=new TreeNode(2);
        A.right=new TreeNode(3);
        A.left.left=new TreeNode(4);
        A.left.right=new TreeNode(5);
        A.right.left=new TreeNode(6);
        A.right.right=new TreeNode(7);

        System.out.print(invertTree(A));
    }
    private static TreeNode invertTree(TreeNode A){
        if (A == null)
            return A;

        TreeNode tmp = A.left;
        A.left = invertTree(A.right);
        A.right = invertTree(tmp);

        return A;
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
