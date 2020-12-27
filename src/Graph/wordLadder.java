package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class wordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Map<String, Boolean> map = new HashMap<>();
		for(String str: wordList) {
			map.put(str, false);
		}
		Queue<String> q = new LinkedList<>();
		q.add(beginWord);
		map.put(beginWord, true);
		int ans = 1;
		while(!q.isEmpty()) {
			int size = q.size(); //here we cannot just use q.size() in for loop, that will be against BFS, think abt ths. 
			for(int p = 0; p < size; p++) {
				String temp = q.remove();
				if(temp.equals(endWord)) return ans;
				char[] c = temp.toCharArray();
				for(int i = 0; i < temp.length(); i++) {
					char revert = c[i];
					for(int j = 0; j < 26; j++) {
						c[i] = (char)('a' + j);
						if(map.containsKey(String.valueOf(c)) && map.get(String.valueOf(c)) == false) {
							q.add(String.valueOf(c));
							map.put(String.valueOf(c), true);
							
						}
					}
					c[i] = revert; //this is imp, 
				}
			}
			ans++;
		}
		
		
		return 0;
	}
	
	public static void main(String[] args) {
		wordLadder wl = new wordLadder();
		List<String> list = new ArrayList<>();
		list.add("ted");
		list.add("tex");
		list.add("red");
		list.add("tax");
		list.add("tad");
		list.add("den");
		list.add("rex");
		list.add("pee");
		System.out.println(wl.ladderLength("red", "tax", list));
	}

}
