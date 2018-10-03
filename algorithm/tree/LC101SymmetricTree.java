package algorithm.tree;

import java.util.Stack;

public class LC101SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
		Stack<TreeNode> s = new Stack<TreeNode>();
		if (root.left == null || root.right == null)
			return root.left == root.right;

		s.push(root.left);
		s.push(root.right);

		TreeNode left = null;
		TreeNode right = null;
		while (!s.empty()) {
			if (s.size() % 2 != 0)
				return false;
			right = s.pop();
			left = s.pop();
			if (right.val != left.val)
				return false;
            if(left.left!=null&&right.right!=null){
                s.push(left.left);
                s.push(right.right);
            }else{
                if(!(left.left==null&&right.right==null))
                    return false;
            }
            if(right.left!=null&&left.right!=null){
                s.push(right.left);
			    s.push(left.right);
            }else{
                if(!(right.left==null&&left.right==null))
                    return false;
            }
		}
		return true;
	}

	// public boolean symmetric(TreeNode l, TreeNode r) {
	// if (l == null || r == null)
	// return l == r;
	// if (l.val != r.val)
	// return false;
	// if (symmetric(l.left, r.right) == false)
	// return false;
	// if (symmetric(l.right, r.left) == false)
	// return false;
	// return true;
	// }
	//
	// public boolean isSymmetric(TreeNode root) {
	// return symmetric(root, root);
	// }
}
