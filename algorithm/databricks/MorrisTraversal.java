package algorithm.databricks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Node{
    Node left,right;
	int val;
}

//time O(n) space O(1) 
//no stack; no extra space
//every edge is visited at most 3 times
public class MorrisTraversal {
    public void visit(Node n){

    }

    public void inorder(Node root){
        if(root==null)
            return;
        Node current =root;
        while(current!=null) {
        	if(current.left==null) {
        		visit(current);
        		current=current.right;
        	}else {
        		Node pre=current.left;
        		while(pre.right!=null&&pre.right!=current) {
        			pre=pre.right;
        		}
        		if(pre.right==null) {
        			visit(current);
        			pre.right=current;
        			current=current.left;
        		}else {
        			current=current.right;
        			pre.right=null;
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
                    current=current. right;
                }
            }
        }
    }

    public void postorder(Node root){
    	List<Integer> l=new ArrayList<>();
    	l.add(0,1);
        if(root==null)
            return ;
        Node current=root;
        while(current!=null) {
        	if(current.right==null) {
        		//add (0,current.val);
        		current=current.left;
        	}else {
        		Node pre=current.right;
        		while(pre.left!=null&&pre.left!=current) {
        			pre=pre.left;
        		}
        		if(pre.left==null) {
        			pre.left=current;
        			//add (0, current.val);
        			current=current.right;
        		}else {
        			pre.left=null;
        			current=current.left;
        		}
        	}
        }
    }
}
