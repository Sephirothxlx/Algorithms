package algorithm.list;

public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
		ListNode temp = new ListNode(0);
		temp.next = head;
		ListNode head1 = temp;
		while (temp != null && temp.next != null) {
			ListNode l = temp.next;
			ListNode r = temp.next.next;
			if (r == null)
				break;
			l.next = r.next;
			r.next = l;
			temp.next = r;
			temp = l;
		}
		return head1.next;
	}
}
