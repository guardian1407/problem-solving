package com.guardian.problemsolving.scaler.trees;

import java.util.*;

public class LeastCommonAncestor {
    public static void main(String[] args) {
        DeserializeBinaryTree build=new DeserializeBinaryTree();
        TreeNode A=build.getRoot(new ArrayList<>(Arrays.asList(16, 23, 9, -1, 1, 22, 2, 25, 19, 6, 13, -1, 24, 14, -1,
                30, 4, 26, 29, -1, -1, -1, -1, -1, 3, -1, 8, -1, -1, 12, 18, 28, -1, 10, -1, 5, -1, 17, 11, 21, 7, -1,
                -1, -1, 20, -1, -1, -1, -1, -1, 15, -1, -1, -1, -1, -1, -1, -1, 27, -1, -1)));
        int B=32;
        int C=24;

        System.out.print(lca(A,B,C));
    }
    public static int lca(TreeNode A, int B, int C) {
        NodeInfo nodeInfo=lcaHelper(A,B,C,-1,new ArrayList<>(Arrays.asList(false,false)));
        return nodeInfo.flagList.get(0) && nodeInfo.flagList.get(1) ? nodeInfo.lca : -1;
    }
    private static NodeInfo lcaHelper(TreeNode A,int B,int C,int lca,List<Boolean> flagList){
        if(A==null)
            return new NodeInfo(lca,flagList);
        if(A.val==B)
            flagList.set(0,true);
        if(A.val==C)
            flagList.set(1,true);

        if(flagList.get(0) && flagList.get(1))
            return lca==-1 ? new NodeInfo(A.val,flagList) : new NodeInfo(lca,flagList);
        else if(flagList.get(0) || flagList.get(1)){
            lca=lca==-1 ? A.val : lca;
            NodeInfo lst=lcaHelper(A.left,B,C,lca,flagList);

            if(flagList.get(0) && flagList.get(1))
                return lst;

            return lcaHelper(A.right,B,C,lca,flagList);
        }
        else{
            NodeInfo lst=lcaHelper(A.left,B,C,lca,flagList);

            if(flagList.get(0) && flagList.get(1))
                return lst;
            else if(flagList.get(0) || flagList.get(1)){
                NodeInfo rst=lcaHelper(A.right,B,C,lca,flagList);

                if(flagList.get(0) && flagList.get(1))
                    return new NodeInfo(A.val,flagList);
                else
                    return rst;
            }
            else
                return lcaHelper(A.right,B,C,lca,flagList);
        }
    }
    private static class NodeInfo{
        int lca;
        List<Boolean> flagList;

        public NodeInfo(int lca, List<Boolean> flagList) {
            this.lca = lca;
            this.flagList = flagList;
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
    private static class DeserializeBinaryTree {
        private TreeNode getRoot(ArrayList<Integer> A){
            TreeNode root=new TreeNode(A.get(0));
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            int l=1;
            int r=2;

            while(!queue.isEmpty()){
                TreeNode node= queue.poll();
                node.left=A.get(l)!=-1 ? new TreeNode(A.get(l)) : null;
                node.right=A.get(r)!=-1 ? new TreeNode(A.get(r)) : null;

                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);

                l+=2;
                r+=2;
            }
            return root;
        }
    }
}

