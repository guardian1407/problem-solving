package com.guardian.problemsolving.scaler.linkedlists;

public class PartitionList {
    public static void main(String[] args) {
        ListNode A=new ListNode(4);
        ListNode T=A;
        T.next=new ListNode(1);
        T=T.next;
        T.next=new ListNode(3);
        T=T.next;
        T.next=new ListNode(2);
        T=T.next;
        T.next=new ListNode(5);
        T=T.next;
        T.next=new ListNode(2);
        int B=3;

        ListNode ans=partition(A,B);

        while(ans!=null){
            System.out.print(ans.val+"->");
            ans=ans.next;
        }
    }
    private static ListNode partition(ListNode A, int B){
        ListNode C=null;
        ListNode tailC=null;

        while(A!=null && A.val>=B){
            if(C==null){
                C=A;
                tailC=C;
            }
            else{
                tailC.next=A;
                tailC=tailC.next;
            }
            A=A.next;
        }

        if(A==null)
            return C;
        else{
            ListNode curr=A;
            ListNode next=curr.next;

            while(next!=null){
                if(next.val<B){
                    curr=next;
                    next=curr.next;
                }
                else{
                    curr.next=next.next;
                    next.next=null;

                    if(C==null){
                        C=next;
                        tailC=next;
                    }
                    else{
                        tailC.next=next;
                        tailC=tailC.next;
                    }
                    next=curr.next;
                }
            }
            curr.next=C;
            return A;
        }
    }
    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
