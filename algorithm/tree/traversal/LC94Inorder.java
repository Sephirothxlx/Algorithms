package algorithm.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import algorithm.tree.TreeNode;

public class LC94Inorder {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> l = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode temp = root;
		while (temp != null || !s.isEmpty()) {
			if (temp != null) {
				s.push(temp);
				temp = temp.left;
			} else {
				temp = s.pop();
				l.add(temp.val);
				temp = temp.right;
			}
		}
		return l;
	}
}
