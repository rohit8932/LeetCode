package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAnagram {
	
	public  List<List<String>> groupAnagrams(String[] strs){
		Map<String, List<String>> map = new HashMap<>();
		List<List<String>> result = new ArrayList<>();
		for(String s : strs) {
			String index = convertToAscii(s);
			if(map.get(index) == null) {
				map.put(index, new ArrayList<String>(Arrays.asList(s)));
			}else {
				map.get(index).add(s);
			}
		}
		
		for(Map.Entry<String, List<String>> entry : map.entrySet()) {
			result.add(entry.getValue());
		}
		return result;
	}
	
	private String convertToAscii(String s) {
		char[] ca = s.toCharArray();
		Arrays.sort(ca);
		
		return String.valueOf(ca); 
	}
	
	public static void main(String[] args) {
		groupAnagram ga = new groupAnagram();
		List<List<String>> result = ga.groupAnagrams(new String[] {"its", "get", "tar", "tip", "eat", "tea", "tan", "ate", "nat", "bat", 
				"duh", "ill"});
		for(List<String> list : result) {
			for(String s : list) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
		
		
	}
	
}
