package algorithm.tree.traversal;

import algorithm.tree.TreeNode;

public class LC538 {
	// public TreeNode convertBST(TreeNode root) {
    //     if(root==null){
    //         return null;
    //     }
    //     Stack<TreeNode>s=new Stack<>();
    //     int sum=0;
    //     TreeNode t=root;
    //     while(root!=null||!s.empty()){
    //         if(root!=null){
    //             s.push(root);
    //             root=root.right;
    //         }else{
    //             TreeNode temp=s.pop();
    //             temp.val=temp.val+sum;
    //             sum=temp.val;
    //             root=temp.left;
    //         }
    //     }
    //     return t;
    // }
    // int sum=0;
    // public TreeNode convertBST(TreeNode root) {
    //     if(root!=null){
    //         convertBST(root.right);
    //         sum+=root.val;
    //         root.val=sum;
    //         convertBST(root.left);
    //     }
    //     return root;
    // }
    public TreeNode convertBST(TreeNode root) {
        if(root==null)
            return root;
        TreeNode curr=root;
        int sum=0;
        while(curr!=null){
            if(curr.right==null){
                sum+=curr.val;
                curr.val=sum;
                curr=curr.left;
            }else{
                TreeNode temp=curr.right;
                while(temp.left!=null&&temp.left!=curr){
                    temp=temp.left;
                }
                if(temp.left==null){
                    temp.left=curr;
                    curr=curr.right;
                }else{
                    temp.left=null;
                    sum+=curr.val;
                    curr.val=sum;
                    curr=curr.left;
                }
            }
        }
        return root;
    }
}
