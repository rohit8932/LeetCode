package other;

import java.util.HashMap;
import java.util.Map;

public class minWindowSubStringSlidingWindow {
	
	public String minWindowSubString(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		for(char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		int begin = 0, end = 0;
		int counter = map.size();
		int minSubstringLen = Integer.MAX_VALUE;
		String ans = "";
		
		while(end < s.length()) {
			char endChar = s.charAt(end);
			if(map.get(endChar) != null) {
				map.put(endChar, map.get(endChar) - 1);
				if(map.get(endChar) == 0) counter --;
			}
			end ++;
			while(counter == 0) {
				char beginChar = s.charAt(begin);
				if(map.get(beginChar) != null) {
					map.put(beginChar, map.get(beginChar) + 1);
					if(map.get(beginChar) > 0) counter ++;
				}
				begin ++;
				if(end - begin < minSubstringLen) {
					ans = s.substring(begin - 1, end);
					minSubstringLen = end  - begin;
				}
				
			}
			
		}
		return ans;
		
	}
	public static void main(String[] args) {
		minWindowSubStringSlidingWindow minWin = new minWindowSubStringSlidingWindow();
		System.out.println(minWin.minWindowSubString("ABCBECODEBANC", "ABC"));
	}
	

}
