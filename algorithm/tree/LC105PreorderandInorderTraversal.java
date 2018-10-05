package algorithm.tree;

public class LC105PreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0)
			return null;
		TreeNode root = null;
		root = new TreeNode(preorder[0]);
		int t1 = -1;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == preorder[0]) {
				t1 = i;
				break;
			}
		}
		int[] inorder1 = new int[t1];
		int[] inorder2 = new int[inorder.length - t1 - 1];
		int[] preorder1 = new int[t1];
		int[] preorder2 = new int[inorder.length - t1 - 1];
		System.arraycopy(inorder, 0, inorder1, 0, t1);
		System.arraycopy(inorder, t1 + 1, inorder2, 0, inorder.length - t1 - 1);
		System.arraycopy(preorder, 1, preorder1, 0, t1);
		System.arraycopy(preorder, t1 + 1, preorder2, 0, inorder.length - t1 - 1);
		root.left = buildTree(preorder1, inorder1);
		root.right = buildTree(preorder2, inorder2);
		return root;
	}
}
