package algorithm.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import algorithm.tree.TreeNode;

public class Preorder {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> l = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode temp = root;
		while (temp != null || !s.isEmpty()) {
			if (temp != null) {
				l.add(temp.val);
				s.push(temp);
				temp = temp.left;
			} else {
				temp = s.pop();
				temp = temp.right;
			}
		}
		return l;
	}
	
	public void traverse(TreeNode root) {
		if(root==null)
			return;
		TreeNode temp=root;
		while(temp!=null) {
			System.out.print(temp.val);
			if(temp.left!=null)
				temp=temp.left;
			else if(temp.right!=null)
				temp=temp.right;
			else {
				TreeNode parent=temp.parent;
				while(parent!=null) {
					if(temp==parent.left&&parent.right!=null) {
						temp=parent.right;
						break;
					}else {
						temp=parent;
						parent=parent.parent;
					}
				}
				if(parent==null)
					temp=null;
			}
		}
	}
}
