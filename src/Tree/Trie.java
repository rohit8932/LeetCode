package Tree;

import java.util.Arrays;

public class Trie {
	
	static class TrieNode{
		TrieNode[] children = new TrieNode[26]; //number of possible children 
		boolean isEndOfWord;
		
		TrieNode() {
			isEndOfWord = false;
			Arrays.fill(children, null);
		}
	}
	private  TrieNode root;
	
	public void insert(String key) {
		TrieNode curr = this.root;
		for(char c : key.toCharArray()) {
			if(curr.children[c - 'a'] == null) {
				curr.children[c - 'a'] = new TrieNode();
			}
			curr = curr.children[c - 'a'];
		}
		curr.isEndOfWord = true;
	}
	
	public boolean search(String key) {
		TrieNode curr = this.root;
		for(char c : key.toCharArray()) {
			if(curr.children[c - 'a'] == null) return false;
			
			curr = curr.children[c - 'a'];
		}
		return (curr.isEndOfWord) ? true : false;
		
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.root = new Trie.TrieNode();
		
		trie.insert("rohit");
		System.out.println(trie.search("rohit"));
	}

}
