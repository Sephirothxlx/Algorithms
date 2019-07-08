package algorithm.list;

public class LC148SortList {
	public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode prev=new ListNode(0);
        prev.next=head;
        ListNode slow=head;
        ListNode fast=head;
        do{
            prev=prev.next;
            slow=slow.next;
            fast=fast.next.next;
        }while(fast!=null&&fast.next!=null);
        prev.next=null;
        ListNode temp1=sortList(head);
        ListNode temp2=sortList(slow);
        return merge(temp1,temp2);
    }
    
    public ListNode merge(ListNode head1, ListNode head2){
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        ListNode dummy1=new ListNode(0);
        dummy1.next=head1;
        ListNode temp1=head1;
        ListNode prev1=dummy1;
        ListNode temp2=head2;
        while(temp1!=null&&temp2!=null){
            if(temp1.val<=temp2.val){
                temp1=temp1.next;
                prev1=prev1.next;
            }else {
                prev1.next=temp2;
                temp2=temp2.next;
                prev1.next.next=temp1;
                prev1=prev1.next;
            }
        }
        if(temp1==null){
            prev1.next=temp2;
        }
        return dummy1.next;
    }
}
