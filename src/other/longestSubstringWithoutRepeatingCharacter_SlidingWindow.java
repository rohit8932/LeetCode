package other;

import java.util.HashMap;
import java.util.Map;

public class longestSubstringWithoutRepeatingCharacter_SlidingWindow {
	
	public int longestSubstringWithoutRepeating(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int end = 0, begin = 0, counter = 0;
		int ans = Integer.MIN_VALUE;
		while(end < s.length()) {
			char endChar = s.charAt(end);
			if(map.get(endChar) != null && map.get(endChar) > 0) {
				counter ++;
			}
			map.put(endChar, map.getOrDefault(endChar, 0) + 1);
			
			end ++;
			
			while(counter > 0) {
				char beginChar= s.charAt(begin);
				map.put(beginChar, map.get(beginChar) - 1);
				if(map.get(beginChar) == 1 ) counter --;
				begin ++;
			}
			
			ans = Math.max(ans, end - begin);
			
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		longestSubstringWithoutRepeatingCharacter_SlidingWindow lswr = new longestSubstringWithoutRepeatingCharacter_SlidingWindow();
		System.out.println(lswr.longestSubstringWithoutRepeating("abba"));
		
	}

}
