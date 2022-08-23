package com.guardian.problemsolving.scaler.trees;

import java.util.Stack;

public class BSTIterator {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(5);
        A.left=new TreeNode(2);
        A.right=new TreeNode(8);
        A.left.left=new TreeNode(1);
        A.left.right=new TreeNode(4);
        A.right.left=new TreeNode(6);
        A.right.right=new TreeNode(11);

        BSTIterator iterator=new BSTIterator(A);
        while(iterator.hasNext())
            System.out.print(iterator.next()+" ");
    }

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack=new Stack<>();
        if(root!=null)
            initialize(root);
    }

    private void initialize(TreeNode node){
        if(node.left==null)
            stack.push(node);
        else{
            stack.push(node);
            initialize(node.left);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if(!stack.isEmpty()){
            TreeNode curr=stack.peek();
            findNext();
            return curr.val;
        }
        else
            return -1;
    }

    private void findNext() {
        if(!stack.isEmpty()){
            TreeNode curr=stack.pop();

            if(curr.right!=null)
                initialize(curr.right);
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
        left=null;
        right=null;
    }
}
