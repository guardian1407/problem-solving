package com.guardian.problemsolving.scaler.trees;

public class LargestBSTSubtree {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(5);
        A.left=new TreeNode(3);
        A.right=new TreeNode(8);
        A.left.left=new TreeNode(1);
        A.left.right=new TreeNode(4);
        A.right.left=new TreeNode(7);
        A.right.right=new TreeNode(9);

        System.out.print(solve(A));
    }
    private static int solve(TreeNode A){
        return isBst(A).count;
    }
    private static NodeInfo isBst(TreeNode node){
        if(node==null)
            return new NodeInfo(true,true,0);

        NodeInfo lst=isBst(node.left);
        NodeInfo rst=isBst(node.right);

        if(lst.isBst && rst.isBst && checkNode(node))
            return new NodeInfo(true,true,lst.count+rst.count+1);
        else
            return new NodeInfo(false,lst.found || rst.found,Math.max(lst.count,rst.count));
    }
    private static boolean checkNode(TreeNode node){
        if(node.left==null && node.right==null)
            return true;
        else if(node.left==null)
            return node.val<node.right.val;
        else if(node.right==null)
            return node.val>node.left.val;
        else
            return node.left.val<node.val && node.val<node.right.val;
    }
    private static class NodeInfo {
        boolean isBst;
        boolean found;
        int count;

        public NodeInfo(boolean isBst, boolean found, int count) {
            this.isBst = isBst;
            this.found = found;
            this.count = count;
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
