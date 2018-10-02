package algorithm.tree;

import java.util.Stack;

public class LC100SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q != null)
			return false;
		Stack<TreeNode> s = new Stack<TreeNode>();
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		while (p != null || !s.empty()) {
			if (p != null) {
				if (q == null)
					return false;
				s.push(p);
				s1.push(q);
				p = p.left;
				q = q.left;
			} else {
				p = s.pop();
				p = p.right;
			}
		}
		if(!s1.isEmpty())
			return false;
		return true;
	}
}
