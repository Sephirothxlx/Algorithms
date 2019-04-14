package algorithm.tree;

import java.util.LinkedList;
import java.util.List;

public class AllPath {
	//backtracking
	public void helper(List<List<Integer>> set,LinkedList<Integer>l, TreeNode root){
        l.add(root.val);
        if(root.left==null&&root.right==null){
            set.add(new LinkedList<Integer>(l));
        }else{
            if(root.left!=null){
                helper(set,l,root.left);
            }
            if(root.right!=null)
                helper(set,l,root.right);
        }
        l.removeLast();
    }
}
