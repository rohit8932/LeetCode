package Tree;

import java.util.Arrays;
import java.util.List;

public class LexiographicSortingOfString {
	static class TrieNode{
		TrieNode[] children;
		String key;
		TrieNode(){
			children = new TrieNode[26];
			Arrays.fill(children, null);
			key = null;
		}
	}
	TrieNode root;
	
	public void insert(String str) {
		TrieNode curr = this.root;
		for(char c : str.toCharArray()) {
			if(curr.children[c - 'a'] == null) {
				curr.children[c - 'a'] = new TrieNode();
			}
			curr = curr.children[c -'a'];
		}
		curr.key = str;
//		System.out.println(str);
	}
	
	public void preorderOnTrie(TrieNode root) {
		if(root == null) return;
		
		for(int i = 0; i < 26; i++) {
			if(root.children[i] != null) {
				if(root.children[i].key != null) {
					System.out.println(root.children[i].key);
				}
				preorderOnTrie(root.children[i]);
			}
		}
	}
	
	public void lexiographicOrder(List<String> dict) {
		for(String str : dict) {
			insert(str);
		}
		preorderOnTrie(this.root);
		
	}
	
	public static void main(String[] args) {
		List<String> dict = Arrays.asList(
				"lexicographic", "sorting", "of", "a", "set", "of", "keys",
				"can", "be", "accomplished", "with", "a", "simple", "trie",
				"based", "algorithm", "we", "insert", "all", "keys", "in", 
				"a", "trie", "output", "all", "keys", "in", "the", "trie",
				"by", "means", "of", "preorder", "traversal", "which",
				"results", "in", "output", "that", "is", "in",
				"lexicographically", "increasing", "order",
				"preorder", "traversal", "is", "a", "kind", 
				"of", "depth", "first", "traversal"
			);
		
		LexiographicSortingOfString lexi = new LexiographicSortingOfString();
		lexi.root = new LexiographicSortingOfString.TrieNode();
		
		lexi.lexiographicOrder(dict);
	}

}
