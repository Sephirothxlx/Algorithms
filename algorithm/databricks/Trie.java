package algorithm.databricks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TrieNode{
	String word=null;
	boolean tag=false;
	TrieNode[]child=new TrieNode[26];
	HashMap<Character,TrieNode> map;
	
	TrieNode(){ 
		map=new HashMap<>();
	}
}

public class Trie {
	TrieNode root;
	
	public void insert(String word) {
		char[]c=word.toCharArray();
		TrieNode temp=root;
		for(char x:c) {
			if(!temp.map.containsKey(x)) {
				temp.map.put(x,new TrieNode());
			}
			temp=temp.map.get(x);
		}
		temp.word=word;
		temp.tag=true;
	}
	
	public String search(String word) {
		char[]c=word.toCharArray();
		TrieNode temp=root;
		for(char x:c) {
			if(!temp.map.containsKey(x)) {
				return null;
			}
			temp=temp.map.get(x);
		}
		if(!temp.tag)
			return null;
		return temp.word;
	}
	
	public boolean remove(String word) {
		char[]c=word.toCharArray();
		TrieNode temp=root;
		for(char x:c) {
			if(!temp.map.containsKey(x)) {
				return false;
			}
			temp=temp.map.get(x);
		}
		if(!temp.tag)
			return false;
		temp.tag=false;
		return true;
	}
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> ret=new HashSet<>();
        if(words==null||words.length==0){
            return new ArrayList<String>();
        }
        if(board==null||board[0].length==0){
            return new ArrayList<String>();
        }
        TrieNode root=buildTrie(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,i,j,root,ret);
            }
        }
        return new ArrayList<String>(ret);
    }
    
    public void dfs(char[][]board,int i,int j, TrieNode root, Set<String> ret){
        char c=board[i][j];
        if(c=='1'){
            return;
        }
        if(root.child[c-'a']!=null){
            if(root.child[c-'a'].word!=null){
                ret.add(root.child[c-'a'].word);
            }
        }else{
            return;
        }
        board[i][j]='1';
        if(i-1>=0){
            dfs(board,i-1,j,root.child[c-'a'],ret);
        }
        if(i+1<board.length){
            dfs(board,i+1,j,root.child[c-'a'],ret);
        }
        if(j-1>=0){
            dfs(board,i,j-1,root.child[c-'a'],ret);
        }
        if(j+1<board[0].length){
            dfs(board,i,j+1,root.child[c-'a'],ret);
        }
        board[i][j]=c;
    }
    
    public TrieNode buildTrie(String []words){
        TrieNode root=new TrieNode();
        for(String x:words){
            TrieNode temp=root;
            for(char c:x.toCharArray()){
                if(temp.child[c-'a']==null){
                    temp.child[c-'a']=new TrieNode();
                }
                temp=temp.child[c-'a'];
            }
            temp.word=x;
        }
        return root;
    }
}
