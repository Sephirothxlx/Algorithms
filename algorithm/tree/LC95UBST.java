package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class LC95UBST {
	public List<TreeNode> generate(int m, int n) {
		if (m > n)
			return null;
		List<TreeNode> l = new ArrayList<TreeNode>();
		if (m == n)
			l.add(new TreeNode(m));
		else
			for (int i = m; i <= n; i++) {
				List<TreeNode> left = generate(m, i - 1);
				List<TreeNode> right = generate(i + 1, n);
				if (left != null && right == null) {
					for (TreeNode o : left) {
                        TreeNode root = new TreeNode(i);
						root.left = o;
						l.add(root);
					}
				} else if (left == null && right != null) {
					for (TreeNode o : right) {
                        TreeNode root = new TreeNode(i);
						root.right = o;
						l.add(root);
					}
				} else if (left != null && right != null) {
					for (TreeNode o : left) {
						for (TreeNode p : right) {
                            TreeNode root = new TreeNode(i);
							root.left = o;
							root.right = p;
							l.add(root);
						}
					}
				}else{
                    TreeNode root = new TreeNode(i);
					l.add(root);
                }
			}
		return l;
	}

	public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList<TreeNode>();
		List<TreeNode> l = generate(1, n);
		return l;
	}
}
