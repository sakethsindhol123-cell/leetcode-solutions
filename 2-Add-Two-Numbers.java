/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1=l1;
        ListNode t2=l2;
        int r=0;
        ListNode head=new ListNode();
        ListNode temp=head;
        while(t1!=null && t2!=null)
        {
            int v1=0,v2=0;
            if(t1!=null)
            v1=t1.val;
            if(t2!=null)
            v2=t2.val;
            int sum=v1+v2+r;
            int n=(sum%10 );
            ListNode nn=new ListNode(n);
            temp.next=nn;
            temp=nn;
            if(sum>9)
            r=1;
            else r=0;
            if(t1!=null)
            t1=t1.next;
            if(t2!=null)
            t2=t2.next;
        }
        while(t1!=null)
        {
            //System.out.println("hi");
            int sum=t1.val+r;
            int n=sum%10;
            ListNode nn=new ListNode(n);
            temp.next=nn;
            temp=nn;
            if(sum>9)
            r=1;
            else r=0;
            t1=t1.next;
        }
        while(t2!=null)
        {
            int sum=t2.val+r;
            int n=(sum%10 );
            ListNode nn=new ListNode(n);
            temp.next=nn;
            temp=nn;
            if(sum>9)
            r=1;
            else r=0;
            t2=t2.next;
        }
        if(r!=0)
        {
            ListNode nn=new ListNode(r);
            temp.next=nn;
            temp=nn;
        }
        return head.next;


    }
}