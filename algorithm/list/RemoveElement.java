package algorithm.list;

public class RemoveElement {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int x = 0;
		ListNode temp = head;
		while (temp != null) {
			x++;
			temp = temp.next;
		}
		temp = head;
		if (n == x) {
			return head.next;
		}
		for (int i = 0; i < x - n - 1; i++) {
			temp = temp.next;
		}
		// when temp=head, any operation to temp = any operation to head
		ListNode temp2 = temp.next;
		temp.next = temp2.next;
		return head;
	}
}
