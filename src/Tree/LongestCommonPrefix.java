package Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestCommonPrefix {
	
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
	
	public String longestCommonPrefix(List<String> dict) {
		for(String s : dict) {
			insert(s);
		}
		String ans = "";
		TrieNode curr = this.root;
		while(curr.isEndOfWord == false &&  curr.children.size() < 2) {
			for(Map.Entry<Character, TrieNode> entry : curr.children.entrySet()) {
				ans += entry.getKey();
				curr = curr.children.get(entry.getKey());
				break;
			}
			
		}
		return ans;
	}
	
	public static void main(String[] args) {
		LongestCommonPrefix lcp = new  LongestCommonPrefix();
		lcp.root = new LongestCommonPrefix.TrieNode();
		List<String> dict = Arrays.asList(
				"code", "coder", "coding", "codable", "codec", "codecs",
				"coded", "codeless", "codependence", "codependency", 
				"codependent", "codependents", "codes", "codesign",
				"codesigned", "codeveloped", "codeveloper", "codex",
				"codify", "codiscovered", "codrive"
			);
		System.out.println(lcp.longestCommonPrefix(dict));
	}

}
