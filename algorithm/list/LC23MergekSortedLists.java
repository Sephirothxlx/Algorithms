package algorithm.list;

import java.util.PriorityQueue;

public class LC23MergekSortedLists {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        ListNode l=null;
        PriorityQueue<Integer> q=new PriorityQueue<Integer>();
        for(int i=0;i<lists.length;i++){
        	ListNode temp=lists[i];
        	while(temp!=null){
        		q.add(temp.val);
        		temp=temp.next;
        	}
        }
        if(q.isEmpty())
            return null;
        l=new ListNode(q.poll());
        ListNode temp2=l;
        while(!q.isEmpty()){
        	temp2.next=new ListNode(q.poll());
        	temp2=temp2.next;
        }
        return l;
    }
}
