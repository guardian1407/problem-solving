package com.guardian.problemsolving.scaler.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class PostorderTraversal {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(1);
        A.left=new TreeNode(6);
        A.right=new TreeNode(2);
        A.right.left=new TreeNode(3);
        postorderTraversal(A).forEach(N->System.out.print(N+" "));
    }
    private static ArrayList<Integer> postorderTraversal(TreeNode A){
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<TreeNode> S=new Stack<>();

        while(A!=null || !S.isEmpty()){
            if(A!=null){
                ans.add(A.val);
                if(A.left!=null)
                    S.push(A.left);
                A=A.right;
            }
            else
                A=S.pop();
        }
        Collections.reverse(ans);
        return ans;
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
