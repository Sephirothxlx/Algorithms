package algorithm.list.dummynode;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
public class LC147 {
	public ListNode insertionSortList(ListNode head) {
        if(head==null)
            return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode temp=dummy;
        ListNode pre=head;
        ListNode cur=head.next;
        while(cur!=null){
            temp=dummy;
            while(temp.next.val<=cur.val&&temp.next!=cur){
                temp=temp.next;
            }
            if(temp.next!=cur){
                pre.next=cur.next;
                cur.next=temp.next;
                temp.next=cur;
            }
            pre=cur;
            cur=cur.next;
        }
        return dummy.next;
    }
}
