package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class findAllAnagramInString {

//	public List<Integer> findAnagrams(String s, String p) {
//
////		return bruteForce(s, p);
//		return efficient(s, p);
//	}

	public List<Integer> bruteForce(String s, String p) {
		int len = p.length();
		boolean found = true;
		List<Integer> ans = new ArrayList<>();
		char[] org = p.toCharArray();
		Arrays.sort(org);

		for (int i = 0; i <= s.length() - len; i++) {
			found = true;
			char[] temp = s.substring(i, i + len).toCharArray();
			Arrays.sort(temp);
			for (int j = 0; j < len; j++) {
				if (org[j] != temp[j]) {
					found = false;
					break;
				}
			}
			if (found == true)
				ans.add(i);
		}
		return ans;

	}
	
	public List<Integer> efficient(String s, String p){
		List<Integer> ans = new ArrayList<>();
		if(p.length() > s.length()) return ans;
		LinkedList<Character> ll = new LinkedList<>();
		int len = p.length();
		for(int i = 0; i < len - 1; i++) {
			ll.add(s.charAt(i));
		}
		
		for(int i = len - 1; i < s.length(); i++) {
			ll.add(s.charAt(i));
			if(check(p, ll)) {
				ans.add(i - (len - 1));
			}
			ll.removeFirst();
		}
		return ans;
		
	}
	
	boolean check(String p, List<Character> ll) {
		HashSet<Character> set1 = new HashSet<>();
		HashSet<Character> set2 = new HashSet<>();
		
		for(char c : p.toCharArray()) {
			set1.add(c);
		}
		for(Character c : ll) {
			set2.add(c);
		}
		
		for(Character c : set1) {
			if(set2.contains(c)) {
				set2.remove(c);
			}
		}
		if(set2.size() == 0) return true;
		return false;
		
	}
	
	public static void main(String[] args) {
		findAllAnagramInString ana = new findAllAnagramInString();
		List<Integer> ans = ana.findAnagrams_2("cbaebabacd", "abc");
		
		for(int e: ans) {
			System.out.print(e + " ");
		}
	}
	
	
	public List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        
        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;
        
        
        while(end < s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;
            
            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-begin == t.length()){
                    result.add(begin);
                }
                begin++;
            }
            
        }
        return result;
    }

	public List<Integer> findAnagrams_2(String s, String t){
		List<Integer> output = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();
		
		for(char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		int start = 0, end = 0;
		int counter = map.size();
		
		while(end < s.length()) {
			if(map.get(s.charAt(end)) != null){
				map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
				if(map.get(s.charAt(end)) == 0) counter --;
			}
			end ++;
			
			while(counter == 0) {
				if(map.get(s.charAt(start)) != null) {
					map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
					if(map.get(s.charAt(start)) > 0 )
						counter++;
				}
				if(end - start == t.length()) {
					output.add(start);
				}
				start++;
				
			}
			
			
			
			
		}
		return output;
		
		
	}
}
