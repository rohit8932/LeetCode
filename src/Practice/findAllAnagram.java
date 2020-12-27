package Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findAllAnagram {

	public List<Integer> findAnagram(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		List<Integer> ans = new ArrayList<>();
		for(char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		int begin = 0, end = 0, counter = map.size();
		
		while(end < s.length()) {
			char now = s.charAt(end);
			if(map.containsKey(now)) {
				map.put(now, map.get(now) - 1);
				if(map.get(now) == 0) counter--;
			}
			end++;
			while(counter == 0) {
				char revert = s.charAt(begin);
				if(map.containsKey(revert) ) {
					map.put(revert, map.get(revert) + 1);
					if(map.get(revert) > 0 ) counter ++; //as soon as number becomes positive increase the counter
				}
				if(end - begin == t.length() ) {
					ans.add(begin);
				}
				begin ++;
			}
		}
		return ans;
	}
	
	
	public static void main(String[] args) {
		findAllAnagram ana = new findAllAnagram();
		List<Integer> ans = ana.findAnagram("bababc", "abc");
		for(int i : ans) System.out.print(i + " ");
				
	}
}
