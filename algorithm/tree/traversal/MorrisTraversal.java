package algorithm.tree.traversal;

public class MorrisTraversal {
	public class Node{
		Node left;
		Node right;
	}
	
	public void visit(Node n){
		
	}
	
	public void inorder(Node root){
		if(root==null)
			return;
		Node current=root;
		while(current!=null){
			if(current.left==null){
				visit(current);
				current=current.right;
			}else{
				Node predecessor=current.left;
				while(predecessor.right!=current&&predecessor.right!=null){
					predecessor=predecessor.right;
				}
				if(predecessor.right==null){
					predecessor.right=current;
					current=current.left;
				}else{
					predecessor.right=null;
					visit(current);
					current=current.right;
				}
			}
		}
	}
	
	public void preorder(Node root){
		if(root==null)
			return;
		Node current=root;
		while(current!=null){
			if(current.left==null){
				visit(current);
				current=current.right;
			}else{
				Node predecessor=current.left;
				while(predecessor.right!=current&&predecessor.right!=null){
					predecessor=predecessor.right;
				}
				if(predecessor.right==null){
					predecessor.right=current;
					visit(current);
					current=current.left;
				}else{
					predecessor.right=null;
					current=current.right;
				}
			}
		}
	}
}
