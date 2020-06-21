package Tree;

import java.util.HashMap;
import java.util.Map;

public class TrieNode_Map {
	static class TrieNode{
		Map<Character, TrieNode> children;
		boolean isEndOfWord;
		TrieNode(){
			children = new HashMap<>();
			isEndOfWord = false;
		}
	}
	TrieNode root; 
	
	public void insert(String str) {
		TrieNode curr = this.root;
		for(char c : str.toCharArray()) {
			if(curr.children.get(c) == null) {
				curr.children.put(c, new TrieNode());
			}
			curr = curr.children.get(c);
		}
		curr.isEndOfWord = true;
	}
	
	public boolean search(String str) {
		TrieNode curr = root;
		for(char c : str.toCharArray()) {
			if(curr.children.get(c) == null) return false;
			curr = curr.children.get(c);
		}
		return (curr.isEndOfWord)? true : false;
	}

	public boolean isPrefix(String prefix) {
		TrieNode curr = this.root;
		for(char c : prefix.toCharArray()) {
			if(curr.children.get(c) == null) return false;
			curr = curr.children.get(c);
		}
		return (curr.isEndOfWord)? false : true;
	}
	
	public static void main(String[] args) {
		TrieNode_Map trie = new TrieNode_Map();
		trie.root = new TrieNode_Map.TrieNode();
		trie.insert("rohit");
		System.out.println(trie.search("rohit"));
		System.out.println(trie.isPrefix("roh"));
	}
}
