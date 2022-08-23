package com.guardian.problemsolving.scaler.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DeserializeBinaryTree {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1));
        TreeNode root=solve(A);
        System.out.print(root);
    }
    private static TreeNode solve(ArrayList<Integer> A){
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
