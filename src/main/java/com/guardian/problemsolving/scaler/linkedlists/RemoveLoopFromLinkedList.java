package com.guardian.problemsolving.scaler.linkedlists;

import java.util.HashSet;
import java.util.Set;

public class RemoveLoopFromLinkedList {
    public static void main(String[] args) {
        ListNode A=new ListNode(3);
        ListNode T=A;
        T.next=new ListNode(2);
        T=T.next;
        T.next=new ListNode(4);
        T=T.next;
        ListNode L=T;
        T.next=new ListNode(5);
        T=T.next;
        T.next=new ListNode(6);
        T=T.next;
        T.next=L;

        ListNode ans=solve(A);

        while(ans!=null){
            System.out.print(ans.val+"->");
            ans=ans.next;
        }
    }
    private static ListNode solve(ListNode A){
        Set<ListNode> nodeSet=new HashSet<>();
        nodeSet.add(A);
        ListNode T=A;

        while(!nodeSet.contains(T.next)){
            T=T.next;
            nodeSet.add(T);
        }

        T.next=null;
        return A;
    }
    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
