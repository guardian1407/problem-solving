package com.guardian.problemsolving.scaler.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(1);
        A.left=new TreeNode(2);
        A.right=new TreeNode(3);
        A.right.left=new TreeNode(4);
        A.right.left.right=new TreeNode(5);

        solve(A).forEach(node->System.out.print(node+" "));
    }
    private static ArrayList<Integer> solve(TreeNode A){
        ArrayList<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(A);

        while(!queue.isEmpty()){
            int size=queue.size();
            list.add(queue.peek().val);

            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();

                if(node.right!=null)
                    queue.offer(node.right);
                if(node.left!=null)
                    queue.offer(node.left);
            }
        }
        return list;
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
