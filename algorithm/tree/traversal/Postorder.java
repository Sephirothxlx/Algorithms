package algorithm.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import algorithm.tree.TreeNode;

public class Postorder {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> l = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode temp = null;
		TreeNode prev = null;
		s.push(root);
		while (!s.isEmpty()) {
			temp = s.peek();
			//leaf
			if (temp.left == null && temp.right == null) {
				l.add(temp.val);
				prev = temp;
				s.pop();
			//parent
			} else if (prev != null && (temp.left == prev || temp.right == prev)) {
				l.add(temp.val);
				prev = temp;
				s.pop();
			} else {
				if (temp.right != null)
					s.push(temp.right);
				if (temp.left != null)
					s.push(temp.left);
			}
		}
		return l;
	}
}
