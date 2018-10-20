package algorithm.tree.traversal;

public class LC117 {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		TreeLinkNode te = root;
		while (te != null) {
			TreeLinkNode temp = te;
			while (temp != null) {
				TreeLinkNode t = null;
				if (temp.left != null) {
					temp.left.next = temp.right;
					if (temp.right == null)
						t = temp.left;
					else
						t = temp.right;
				} else {
					if (temp.right == null) {
						temp = temp.next;
						while (temp != null) {
							if (temp.left != null || temp.right != null)
								break;
							temp = temp.next;
						}
						continue;
					} else
						t = temp.right;
				}
				if (t != null) {
					if (temp.next != null) {
						TreeLinkNode temp2 = temp.next;
						while (temp2 != null) {
							if (temp2.left != null || temp2.right != null)
								break;
							temp2 = temp2.next;
						}
						if (temp2 == null)
							t.next = null;
						else if (temp2.left != null)
							t.next = temp2.left;
						else if (temp2.right != null)
							t.next = temp2.right;
					} else {
						t.next = null;
					}
				}
				temp = temp.next;
			}
			while (te != null) {
				if (te.left != null) {
					te = te.left;
					break;
				} else if (te.right != null) {
					te = te.right;
					break;
				} else
					te = te.next;
			}
		}
	}
}
