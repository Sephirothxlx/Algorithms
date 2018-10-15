package algorithm.tree.traversal;

import algorithm.tree.TreeLinkNode;

public class LC116PopulatingNextRightPointersinEachNode {
	public void connect(TreeLinkNode root) {
		TreeLinkNode temp = root;
		while (temp != null) {
			TreeLinkNode cur = temp;
			while (cur != null) {
				if (cur.left != null)
					cur.left.next = cur.right;
				if (cur.right != null && cur.next != null)
					cur.right.next = cur.next.left;
				cur = cur.next;
			}
			temp = temp.left;
		}
	}
}
