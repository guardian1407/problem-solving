package com.guardian.problemsolving.scaler.trees;

import java.util.ArrayList;
import java.util.Stack;

public class MergeTwoBSTs {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(5);
        A.left=new TreeNode(3);
        A.right=new TreeNode(8);

        TreeNode B=new TreeNode(7);
        B.left=new TreeNode(2);
        B.right=new TreeNode(9);

        solve(A,B).forEach(val->System.out.print(val+" "));
    }
    private static ArrayList<Integer> solve(TreeNode A, TreeNode B){
        ArrayList<Integer> ans=new ArrayList<>();
        BSTIterator iteratorA=new BSTIterator(A);
        BSTIterator iteratorB=new BSTIterator(B);

        while(iteratorA.hasNext() && iteratorB.hasNext()){
            int valA=iteratorA.peek();
            int valB=iteratorB.peek();

            if(valA<=valB){
                ans.add(valA);
                iteratorA.next();
            }
            else{
                ans.add(valB);
                iteratorB.next();
            }
        }
        if(iteratorA.hasNext()){
            while(iteratorA.hasNext())
                ans.add(iteratorA.next());
        }
        if(iteratorB.hasNext()){
            while(iteratorB.hasNext())
                ans.add(iteratorB.next());
        }
        return ans;
    }
    private static class BSTIterator {
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

        public int peek() {
            if(!stack.isEmpty())
                return stack.peek().val;
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

