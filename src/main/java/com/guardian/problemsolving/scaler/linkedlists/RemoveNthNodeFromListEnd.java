package com.guardian.problemsolving.scaler.linkedlists;

public class RemoveNthNodeFromListEnd {
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
        int B=1;

        ListNode ans=removeNthFromEnd(A,B);

        while(ans!=null){
            System.out.print(ans.val+"->");
            ans=ans.next;
        }
    }
    private static ListNode removeNthFromEnd(ListNode A, int B){
        ListNode prev=null;
        ListNode curr=A;
        ListNode last=A;

        while(B>1 && last!=null){
            last=last.next;
            B--;
        }

        if(last==null || last.next==null){
            last=A.next;
            A.next=null;
            A=last;
        }
        else{
            while(last.next!=null){
                prev=curr;
                curr=curr.next;
                last=last.next;
            }
            prev.next=curr.next;
            curr.next=null;
        }
        return A;
    }
    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
