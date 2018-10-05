package algorithm.tree;

public class LC106InorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder.length == 0)
			return null;
		TreeNode root = null;
		root = new TreeNode(postorder[postorder.length-1]);
		int t1 = -1;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == postorder[postorder.length-1]) {
				t1 = i;
				break;
			}
		}
		int[] inorder1 = new int[t1];
		int[] inorder2 = new int[inorder.length - t1 - 1];
		int[] postorder1 = new int[t1];
		int[] postorder2 = new int[inorder.length - t1 - 1];
		System.arraycopy(inorder, 0, inorder1, 0, t1);
		System.arraycopy(inorder, t1 + 1, inorder2, 0, inorder.length - t1 - 1);
		System.arraycopy(postorder, 0, postorder1, 0, t1);
		System.arraycopy(postorder, t1, postorder2, 0, inorder.length - t1 - 1);
		root.left = buildTree(inorder1, postorder1);
		root.right = buildTree(inorder2, postorder2);
		return root;
	}
}
