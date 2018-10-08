package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class LC111MinimumDepthofBinaryTree {
	public boolean check(TreeNode root) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null)
			return true;
		else
			return false;
	}

	public void traverse(TreeNode root, int x, List<Integer> a) {
		if (root == null)
			return;
		if (check(root)) {
			a.add(x);
		} else {
			traverse(root.left, x + 1, a);
			traverse(root.right, x + 1, a);
		}
	}

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		List<Integer> l = new ArrayList<Integer>();
		traverse(root, 1, l);
		int small = Integer.MAX_VALUE;
		for (int i = 0; i < l.size(); i++) {
			if (small > l.get(i))
				small = l.get(i);
		}
		return small;
	}
}
