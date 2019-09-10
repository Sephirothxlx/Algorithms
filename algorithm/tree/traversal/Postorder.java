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
			temp=s.pop();
			l.add(0,temp.val);
			if(temp.left!=null)
				s.push(temp.left);
			if(temp.right!=null)
				s.push(temp.right);
		}
		return l;
	}
	
	
}
