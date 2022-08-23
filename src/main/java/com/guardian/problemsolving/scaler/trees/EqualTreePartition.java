package com.guardian.problemsolving.scaler.trees;

public class EqualTreePartition {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(5);
        A.left=new TreeNode(3);
        A.right=new TreeNode(7);
        A.left.left=new TreeNode(4);
        A.left.right=new TreeNode(6);
        A.right.left=new TreeNode(5);
        A.right.right=new TreeNode(6);

        System.out.print(solve(A));
    }
    private static int solve(TreeNode A){
        return hasEqualPartition(A,getTreeSum(A)).isPossible ? 1 : 0;
    }
    private static NodeInfo hasEqualPartition(TreeNode node,long totalSum){
        if(node==null)
            return new NodeInfo(0,false);

        if(node.left==null && node.right==null)
            return new NodeInfo(node.val,false);
        else if(node.left==null)
            return checkSubtree(node,hasEqualPartition(node.right,totalSum),totalSum);
        else if(node.right==null)
            return checkSubtree(node,hasEqualPartition(node.left,totalSum),totalSum);
        else{
            NodeInfo lst=hasEqualPartition(node.left,totalSum);
            NodeInfo rst=hasEqualPartition(node.right,totalSum);

            if(lst.isPossible || rst.isPossible || totalSum-lst.bottomSum==lst.bottomSum || totalSum-rst.bottomSum==rst.bottomSum)
                return new NodeInfo(lst.bottomSum+ rst.bottomSum+node.val,true);
            else
                return new NodeInfo(lst.bottomSum+ rst.bottomSum+node.val,false);
        }
    }
    private static NodeInfo checkSubtree(TreeNode node,NodeInfo st,long totalSum){
        if(st.isPossible || totalSum-st.bottomSum==st.bottomSum)
            return new NodeInfo(st.bottomSum+node.val,true);
        else
            return new NodeInfo(st.bottomSum+node.val,false);
    }
    private static long getTreeSum(TreeNode node){
        if(node==null)
            return 0;

        long lst=getTreeSum(node.left);
        long rst=getTreeSum(node.right);

        return node.val+lst+rst;
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
