package com.guardian.problemsolving.scaler.test;

public class Test1 {
    public static void main(String[] args) {
        ListNode A=new ListNode(1);
        ListNode T=A;
        T.next=new ListNode(2);
        T=T.next;
        T.next=new ListNode(3);
        T=T.next;
        T.next=new ListNode(2);
        T=T.next;
        T.next=new ListNode(1);
        int B=3;

        System.out.print(reverseList(A,B));
    }
    private static ListNode reverseList(ListNode A, int B) {
        ListNode prev=null;
        ListNode curr=A;
        ListNode next=curr.next;

        ListNode second=null;
        ListNode tail=null;

        while(curr!=null){
            if(curr.val>=B){
                if(second==null){
                    second=curr;
                    tail=curr;
                }
                else{
                    tail.next=curr;
                    tail=tail.next;
                }
                curr.next=null;

                curr=next;
                if(prev!=null)
                    prev.next=curr;
            }

            prev=curr;
            curr=next;
            if(curr!=null)
                next=curr.next;
        }

        if(prev!=null && second!=null){
            prev.next=second;
        }
        else if(prev==null){
            A=second;
        }

        return A;
    }
    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
