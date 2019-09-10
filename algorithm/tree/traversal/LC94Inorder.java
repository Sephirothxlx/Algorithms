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
	
	public TreeNode inorderFirst(TreeNode root) {
		if(root==null)
			return null;
		while(root.left!=null) {
			root=root.left;
		}
		return root;
	}
	
	public void traverse(TreeNode root) {
		if(root==null)
			return;
		root=inorderFirst(root);
		while(root!=null) {
			System.out.print(root.val);
			if(root.right!=null) {
				root=inorderFirst(root.right);
			}else {
				TreeNode parent=root.parent;
				while(parent!=null) {
					if(root==parent.left) {
						root=parent;
						break;
					}else {
						root=parent;
						parent=parent.parent;
					}
				}
				if(parent==null)
					root=null;
			}
		}
	}
}
