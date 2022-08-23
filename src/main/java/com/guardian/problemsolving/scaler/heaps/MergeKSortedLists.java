package com.guardian.problemsolving.scaler.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ArrayList<ListNode> A=new ArrayList<>();

        ListNode L=new ListNode(1);
        ListNode T=L;
        T.next=new ListNode(10);
        T=T.next;
        T.next=new ListNode(20);
        A.add(L);

        L=new ListNode(4);
        T=L;
        T.next=new ListNode(11);
        T=T.next;
        T.next=new ListNode(13);
        A.add(L);

        L=new ListNode(3);
        T=L;
        T.next=new ListNode(8);
        T=T.next;
        T.next=new ListNode(9);
        A.add(L);

        ListNode ans=mergeKLists(A);
        while(ans!=null){
            System.out.print(ans.val+"->");
            ans=ans.next;
        }
    }
    private static ListNode mergeKLists(ArrayList<ListNode> a){
        Queue<ListNode> pQueue=new PriorityQueue<>(Comparator.comparingInt(l->l.val));
        a.forEach(head->{
            while(head!=null){
                ListNode next=head.next;
                head.next=null;
                pQueue.offer(head);
                head=next;
            }
        });

        ListNode ans=pQueue.poll();
        ListNode tail=ans;
        while(!pQueue.isEmpty()){
            tail.next=pQueue.poll();
            tail=tail.next;
        }
        return ans;
    }
    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
