package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class LC102BinaryTreeLevelOrderTraversal {
	public void add(TreeNode root, List<List<Integer>> l, int x) {
		if (root == null)
			return;
		List<Integer> ll = null;
		if (x >= l.size()) {
			ll = new ArrayList<Integer>();
			l.add(ll);
		} else
			ll = l.get(x);
		ll.add(root.val);
		add(root.left, l, x + 1);
		add(root.right, l, x + 1);
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		add(root, l, 0);
		return l;
	}
}
