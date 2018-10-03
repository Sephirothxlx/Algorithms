package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class LC103ZigZagBinaryTreeLevelOrderTraversal {
	public void add(TreeNode root, List<List<Integer>> l, int x, int tag) {
		if (root == null)
			return;
		List<Integer> ll = null;
		if (x >= l.size()) {
			ll = new ArrayList<Integer>();
			l.add(ll);
		} else
			ll = l.get(x);
		if (tag % 2 == 0 || ll.size() == 0)
			ll.add(root.val);
		else {
			ll.add(0);
			for (int i = ll.size() - 1; i >= 1; i--) {
				ll.set(i, ll.get(i - 1));
			}
			ll.set(0, root.val);
		}

		add(root.left, l, x + 1, tag + 1);
		add(root.right, l, x + 1, tag + 1);

	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		add(root, l, 0, 0);
		return l;
	}
}
