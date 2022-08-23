package com.guardian.problemsolving.scaler.linkedlists;

public class ReorderList {
    public static void main(String[] args) {
        ListNode A=new ListNode(1);
        ListNode T=A;
        T.next=new ListNode(2);
        T=T.next;
        T.next=new ListNode(3);
        T=T.next;
        T.next=new ListNode(4);
        T=T.next;
        T.next=new ListNode(5);

        ListNode ans=reorderList(A);

        while(ans!=null){
            System.out.print(ans.val+"->");
            ans=ans.next;
        }
    }
    private static ListNode reorderList(ListNode A){
        ListNode slow=A;
        ListNode fast=A;
        ListNode B;
        ListNode prev=null;
        ListNode curr;
        ListNode next;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        if(fast==null){
            if(prev!=null)
                prev.next=null;
            B=slow;
        }
        else{
            B=slow.next;
            slow.next=null;
        }

        if(B!=null){
            prev=null;
            curr=B;
            next=B.next;

            while(curr!=null){
                curr.next=prev;
                prev=curr;
                curr=next;
                if(curr!=null)
                    next=curr.next;
            }
            B=prev;
            curr=A;

            while(curr!=null && B!=null){
                next=curr.next;
                prev=B;
                B=B.next;
                curr.next=prev;
                prev.next=next;
                curr=next;
            }
        }
        return A;
    }
    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
