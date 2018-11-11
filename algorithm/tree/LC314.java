package algorithm.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC314 {
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		if (root == null)
			return l;
		int min = 0;
		int max = 0;
		HashMap<Integer, List<Integer>> h = new HashMap<Integer, List<Integer>>();
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<TreeNode> qq = new LinkedList<TreeNode>();
		q.add(0);
		qq.add(root);
		while (!q.isEmpty()) {
			TreeNode temp = qq.poll();
			int i = q.poll();
			if (!h.containsKey(i)) {
				List<Integer> temp2 = new ArrayList<Integer>();
				h.put(i, temp2);
			}
			h.get(i).add(temp.val);
			if (temp.left != null) {
				q.add(i - 1);
				qq.add(temp.left);
				if (i - 1 < min)
					min = i - 1;
			}
			if (temp.right != null) {
				q.add(i + 1);
				qq.add(temp.right);
				if (i + 1 > max)
					max = i + 1;
			}
		}
		for (int i = min; i <= max; i++) {
			l.add(h.get(i));
		}
		return l;
	}
}
