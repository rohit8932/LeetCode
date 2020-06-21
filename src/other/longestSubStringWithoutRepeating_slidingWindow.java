package other;

import java.util.HashMap;
import java.util.Map;

public class longestSubStringWithoutRepeating_slidingWindow {
	
	public static int lengthOfLongestSubstring(String str) {
		int windowEnd = 0, windowStart = 0;
		Map<Character, Integer> map = new HashMap<>();
		int maxLen = 0;
		
		for(windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			
			while(map.getOrDefault(str.charAt(windowEnd), 0) != 0) {
				map.put(str.charAt(windowStart), map.get(str.charAt(windowStart)) - 1);
				if(map.get(str.charAt(windowStart)) == 0) {
					map.remove(str.charAt(windowStart));
				}
				windowStart++;
			}
			map.put(str.charAt(windowEnd), map.getOrDefault(str.charAt(windowEnd), 0) + 1);
			maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
			
		}
		
		return maxLen;
		
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
	

}
