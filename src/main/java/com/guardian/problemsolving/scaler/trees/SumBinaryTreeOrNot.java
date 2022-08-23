package com.guardian.problemsolving.scaler.trees;

public class SumBinaryTreeOrNot {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(26);
        A.left=new TreeNode(10);
        A.right=new TreeNode(3);
        A.left.left=new TreeNode(4);
        A.left.right=new TreeNode(6);
        A.right.right=new TreeNode(3);

        System.out.print(solve(A));
    }
    private static int solve(TreeNode A){
        return isSumBinary(A).isPossible ? 1 : 0;
    }
    private static NodeInfo isSumBinary(TreeNode node){
        if(node==null)
            return new NodeInfo(0,true);

        if(node.left==null && node.right==null)
            return new NodeInfo(node.val, true);

        NodeInfo lst=isSumBinary(node.left);
        NodeInfo rst=isSumBinary(node.right);

        if(lst.isPossible && rst.isPossible)
            return new NodeInfo(node.val+lst.bottomSum+rst.bottomSum,node.val==lst.bottomSum+rst.bottomSum);
        else
            return new NodeInfo(node.val+lst.bottomSum+rst.bottomSum,false);
    }
    private static class NodeInfo {
        long bottomSum;
        boolean isPossible;

        public NodeInfo(long bottomSum, boolean isPossible) {
            this.bottomSum = bottomSum;
            this.isPossible = isPossible;
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
