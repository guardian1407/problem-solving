package com.guardian.problemsolving.scaler.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(1);
        A.left=new TreeNode(2);
        A.right=new TreeNode(3);
        A.left.left=new TreeNode(4);
        A.left.right=new TreeNode(5);
        A.right.right=new TreeNode(6);

        solve(A).forEach(node->System.out.print(node+" "));
    }
    private static ArrayList<Integer> solve(TreeNode A){
        ArrayList<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(A);

        while(!queue.isEmpty()){
            int size= queue.size();

            for(int i=0;i<size;i++){
                TreeNode node= queue.poll();

                if(node!=null){
                    queue.offer(node.left);
                    queue.offer(node.right);
                    list.add(node.val);
                }
                else
                    list.add(-1);
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
