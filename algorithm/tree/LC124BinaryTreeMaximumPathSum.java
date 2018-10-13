package algorithm.tree;

public class LC124BinaryTreeMaximumPathSum {
	int max = Integer.MIN_VALUE;

	public int traverse(TreeNode root) {
		if (root == null)
			return 0;
		int a = traverse(root.left);
		int b = traverse(root.right);
		int c = a + b + root.val;
		max = Math.max(max, c);
		int d = Math.max(a + root.val, b + root.val);
		if (d <= 0)
			return 0;
		return d;
	}

	public int maxPathSum(TreeNode root) {
		traverse(root);
		if (max == Integer.MIN_VALUE)
			return 0;
		return max;
	}
}
