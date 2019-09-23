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
	
	public TreeNode postOrderFirst(TreeNode root) {
		if(root==null)
			return null;
		while(true) {
			if(root.left!=null)
				root=root.left;
			else if(root.right!=null)
				root=root.right;
			else
				return root;
		}
	}
	
	
	public void postorder(TreeNode root) {
		if(root==null)
			return;
		root=postOrderFirst(root);
		while(root!=null) {
			System.out.println(root.val);
			TreeNode parent=root.parent;
			if(parent!=null) {
				if(parent.left==root&&parent.right!=null) {
					root=postOrderFirst(root.right);
				}else {
					root=parent;
				}
			}else {
				root=null;
			}
		}
	}
}
