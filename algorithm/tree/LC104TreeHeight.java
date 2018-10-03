package algorithm.tree;

public class LC104TreeHeight {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int x = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		return x;
	}
}
