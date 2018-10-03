package algorithm.tree;

public class InvertBinaryTree {
	public void invert(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return;
		} else if (left == null && right != null) {
			
		} else if (left != null && right == null) {

		} else {
			left.val = right.val;
			right.val = left.val;
			invert(left.left, right.right);
			invert(left.right, right.left);
		}
	}

	public TreeNode invertBinaryTree(TreeNode root) {
		invert(root, root);
		return root;
	}
}
