package com.guardian.problemsolving.scaler.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckIfGivenPreorderInorderAndPostorderTraversalsAreOfSameTree {
    public static void main(String[] args) {
        ArrayList<Integer> A= new ArrayList<>(Arrays.asList(1, 5, 4, 2, 3)); //Preorder
        ArrayList<Integer> B= new ArrayList<>(Arrays.asList(4, 2, 5, 1, 3)); //Inorder
        ArrayList<Integer> C= new ArrayList<>(Arrays.asList(4, 5, 2, 3, 1)); //Postorder

        System.out.print(solve(A,B,C));
    }
    private static int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C){
        Map<Integer,Integer> indexMap=new HashMap<>();

        for(int i=0;i<B.size();i++)
            indexMap.put(B.get(i),i);

        NodeInfo tree=construct(A,0,0,B.size()-1,indexMap);

        return tree.isPossible ? (checkPostOrder(C,0,tree.root).isPossible ? 1 : 0) : 0;
    }
    private static NodeInfo construct(ArrayList<Integer> pre,int preIndex,int l,int r,Map<Integer,Integer> indexMap){
        if(l>r)
            return new NodeInfo(null,true,preIndex);

        TreeNode root=new TreeNode(pre.get(preIndex++));

        if(!indexMap.containsKey(root.val))
            return new NodeInfo(root,false,preIndex);

        int inIndex=indexMap.get(root.val);
        if(inIndex<l || inIndex>r)
            return new NodeInfo(root,false,preIndex);

        if(l==r)
            return new NodeInfo(root,true,preIndex);

        NodeInfo lst=construct(pre,preIndex,l,inIndex-1,indexMap);
        preIndex=lst.index;
        if(!lst.isPossible)
            return new NodeInfo(root,false,preIndex);
        root.left=lst.root;

        NodeInfo rst=construct(pre,preIndex,inIndex+1,r,indexMap);
        preIndex=rst.index;
        root.right=rst.isPossible ? rst.root : null;

        return rst.isPossible ? new NodeInfo(root,true,preIndex) : new NodeInfo(root,false,preIndex);
    }
    private static NodeInfo checkPostOrder(ArrayList<Integer> post,int postIndex,TreeNode root){
        if(root==null)
            return new NodeInfo(root,true,postIndex);

        NodeInfo lst=checkPostOrder(post,postIndex,root.left);
        postIndex=lst.index;
        NodeInfo rst=checkPostOrder(post,postIndex,root.right);
        postIndex=rst.index;

        return lst.isPossible && rst.isPossible && root.val==post.get(postIndex)
                ? new NodeInfo(root,true,postIndex+1)
                : new NodeInfo(root,false,postIndex+1);
    }
    private static class NodeInfo{
        TreeNode root;
        boolean isPossible;
        int index;

        public NodeInfo() {
        }

        public NodeInfo(TreeNode root, boolean isPossible, int index) {
            this.root = root;
            this.isPossible = isPossible;
            this.index = index;
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
