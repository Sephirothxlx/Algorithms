package algorithm.tree.traversal;

import java.util.Stack;

import algorithm.tree.TreeNode;

public class LC114FlattenBinaryTreetoLinkedList {
	TreeNode pre=null;
	public void flatten(TreeNode root) {
		if (root == null)
			return;
//		TreeNode temp = null;
//		Stack<TreeNode> s = new Stack<TreeNode>();
//		TreeNode prev = null;
//		s.push(root);
//		while (!s.isEmpty()) {
//			temp = s.pop();
//			if (prev != null) {
//				prev.left = null;
//				prev.right = temp;
//			}
//			prev = temp;
//			if (temp.right != null)
//				s.push(temp.right);
//			if (temp.left != null)
//				s.push(temp.left);
//		}
		flatten(root.right);
		flatten(root.left);
		
	}
}
