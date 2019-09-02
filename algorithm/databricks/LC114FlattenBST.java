package algorithm.databricks;

import java.util.Stack;

public class LC114FlattenBST {
	static Node prev=null;
	//for doubly linked list
	static Node prev2=null;
	
	static void flatten(Node root) {
		if(root==null)
			return;
		Stack<Node> s=new Stack<>();
		s.push(root);
		while(!s.empty()) {
			Node temp=s.pop();
			if(prev!=null) {
				prev.right=temp;
				prev.left=prev2;
			}
			prev2=prev;
			prev=temp;
			if(temp.right!=null)
				s.push(temp.right);
			if(temp.left!=null)
				s.push(temp.left);
		}
		//important!!!!!
		prev.left=prev2;
	}
	
	public static void main(String[]args) {
		Node a=new Node();
		a.val=1;
		Node b=new Node();
		b.val=2;
		Node c=new Node();
		c.val=3;
		Node d=new Node();
		d.val=4;
		Node e=new Node();
		e.val=5;
		Node f=new Node();
		f.val=6;
		a.left=b;
		a.right=e;
		b.left=c;
		b.right=d;
		e.right=f;
		flatten(a);
		Node temp=f;
		while(temp!=null) {
			System.out.print(temp.val);
			temp=temp.left;
		}
	}
}
