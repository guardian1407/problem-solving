package com.guardian.problemsolving.scaler.trees;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(1);
        A.left=new TreeNode(2);
        A.right=new TreeNode(5);
        A.left.left=new TreeNode(3);
        A.left.right=new TreeNode(4);
        A.right.right=new TreeNode(6);

        TreeNode root=flatten(A);

        while(root!=null){
            System.out.print(root.val+" ");
            root=root.right;
        }
    }
    private static TreeNode flatten(TreeNode a){
        if(a==null)
            return null;

        if(a.left!=null){
            TreeNode lst=flatten(a.left);
            TreeNode rst=flatten(a.right);

            a.left=null;
            a.right=lst;
            TreeNode prev=null;

            while(lst!=null){
                prev=lst;
                lst=lst.right;
            }
            prev.right=rst;
        }
        else
            a.right=flatten(a.right);

        return a;
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
