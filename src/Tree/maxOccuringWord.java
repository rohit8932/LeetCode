package Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class maxOccuringWord {
	static class TrieNode{
		Map<Character, TrieNode> children;
		boolean isEndOfWord;
		int count;
		public TrieNode() {
			children =  new HashMap<>() ;
			isEndOfWord = false;
			count = 0;
		}
	}
	TrieNode root;
	
	public int insert(String str) {
		TrieNode curr = this.root;
		for(char c : str.toCharArray()) {
			if(curr.children.get(c) == null) {
				curr.children.put(c, new TrieNode());
			}
			curr = curr.children.get(c);
		}
		curr.isEndOfWord = true;
		curr.count++;
		return curr.count;
		
	}
	
	public void maxOccuringWord_fun(List<String> dict) {
		int max_count = 0, curr_count = 0; String ans = "";
		for(String str : dict) {
			curr_count = insert(str);
			if(curr_count > max_count) {
				max_count = curr_count;
				ans = str;
			}
		}
		
		System.out.println(ans);
		
	}
	
	
	public static void main(String[] args) {
		List<String> dict = Arrays.asList(
				"code", "coder", "coding", "codable", "codec", "codecs",
				"coded", "codeless", "codec", "codecs", "codependence",
				"codex", "codify", "codependents", "codes", "code",
				"coder", "codesign", "codec", "codeveloper", "codrive",
				"codec", "codecs", "codiscovered"
			);
		
		maxOccuringWord max = new maxOccuringWord();
		max.root = new maxOccuringWord.TrieNode();
		max.maxOccuringWord_fun(dict);
		
	}

}
