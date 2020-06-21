package other;

import java.util.HashMap;
import java.util.Map;

public class longesSubstringWithKDistinct_slidingWindow {
	
	public String longestSubstringWithkDistinct(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int end = 0, begin = 0, counter = 0;
		int maxLen = Integer.MIN_VALUE;
		String ans = "";
		while(end < s.length()) {
			char endChar = s.charAt(end);
			if(map.get(endChar) == null ) counter ++;
			map.put(endChar, map.getOrDefault(endChar, 0) + 1);
			end++;
			
			while(counter > k) {
				char beginChar = s.charAt(begin);
				map.put(beginChar, map.get(beginChar) - 1);
				if(map.get(beginChar) == 0) counter --;
				begin++;
			}
			
			if(end - begin > maxLen) {
				ans = s.substring(begin, end);
				maxLen = end - begin;
			}
			
		}
		return ans;
	}
	
	public static void main(String[] args) {
		longesSubstringWithKDistinct_slidingWindow lswkd = new longesSubstringWithKDistinct_slidingWindow();
		System.out.println(lswkd.longestSubstringWithkDistinct("aabacbebebe", 3));
	}

}
