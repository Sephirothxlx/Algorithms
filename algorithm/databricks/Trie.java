package algorithm.databricks;

import java.util.HashMap;

class TrieNode{
	String word=null;
	boolean tag=false;
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
