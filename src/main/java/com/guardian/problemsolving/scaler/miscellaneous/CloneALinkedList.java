package com.guardian.problemsolving.scaler.miscellaneous;

public class CloneALinkedList {
    public static void main(String[] args) {
        ListNode A=new ListNode(1);
        ListNode T=A;
        T.next=new ListNode(2);
        T=T.next;
        ListNode second=T;
        T.next=new ListNode(3);
        T=T.next;
        ListNode third=T;
        T.next=new ListNode(4);
        T=T.next;
        ListNode fourth=T;
        T.next=new ListNode(5);
        T=T.next;
        ListNode fifth=T;

        A.random=fifth;
        second.random=fourth;
        third.random=third;
        fourth.random=second;
        fifth.random=A;

        A=cloneList(A);
        ListNode curr=A;
        while(curr!=null){
            System.out.print(curr.val+"->");
            curr=curr.next;
        }

        System.out.println();
        curr=A;
        while(curr!=null){
            if(curr.random!=null)
                System.out.print(curr.val+"->"+curr.random.val+" ");
            curr=curr.next;
        }
    }
    private static ListNode cloneList(ListNode A){
        ListNode curr=A;

        while(curr!=null){
            ListNode next=curr.next;
            ListNode clone=new ListNode(curr.val);
            curr.next=clone;
            clone.next=next;
            curr=next;
        }

        curr=A;
        while(curr!=null){
            curr.next.random=curr.random.next;
            curr=curr.next.next;
        }

        ListNode ans=A.next;
        curr=A;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=null;
            curr=next.next;

            if(curr!=null)
                next.next=curr.next;
        }
        return ans;
    }
    private static class ListNode {
        public int val;
        public ListNode next;
        public ListNode random;
        ListNode(int x) {
            val = x;
            next = null;
            random = null;
        }
    }
}
