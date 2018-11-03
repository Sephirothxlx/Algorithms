package algorithm.tree;

import java.util.HashMap;

public class LC337 {
	HashMap<TreeNode,Integer> h=new HashMap<TreeNode,Integer>();
	public int[] helper(TreeNode root){
		if(root==null)
			return new int[2];
		int []left=helper(root.left);
		int[]right=helper(root.right);
		int res[]=new int[2];
		res[0]=Math.max(left[0],left[1])+Math.max(right[0], right[1]);
		res[1]=left[0]+right[0]+root.val;
		return res;
	}

	public int rob(TreeNode root) {
		int[]res=helper(root);
		return Math.max(res[0],res[1]);
	}
}
