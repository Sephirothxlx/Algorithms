package algorithm.databricks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Node{
    Node left,right;
}

public class MorrisTraversal {
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
                Node predecessor =current.left;
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
                    current=current. right;
                }
            }
        }
    }

    public void postorder(Node root){
        if(root==null)
            return ;
        Node dummy=new Node();
        dummy.left=root;
        Node current=dummy;
        while(current!=null){
            if(current.left==null){
                current=current.right;
            }else{
                Node predecessor=current.left;
                while(predecessor.right!=root&&predecessor.right!=null)
                    predecessor=predecessor.right;
                if(predecessor.right==null){
                    predecessor.right=current;
                    current=current.left;
                }else{
                    predecessor.right=null;
                    Node temp=current.left;
                    List<Node> list=new ArrayList<>();
                    while(temp!=predecessor){
                        Node temp2=temp;
                        list.add(temp2);
                    }
                    Collections.reverse(list);
                    for(Node t:list)
                        visit(t);
                    current=current.right;
                }
            }
        }
    }
}
