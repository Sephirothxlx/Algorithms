package algorithm.tree;

import java.util.Stack;

public class LC98VBST {
	public boolean isValidBST(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode preNode = null;
		while (root != null || !s.empty()) {
			if (root != null) {
				s.push(root);
				root = root.left;
			} else {
				root = s.pop();
				if (preNode != null && root.val <= preNode.val)
					return false;
				root = root.right;
			}
		}
		return true;
	}
}
