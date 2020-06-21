package other;

import java.util.HashSet;
import java.util.Set;

public class longestSubstringWithoutRepeating {
	
	public static int lswr(String str) {
		if(str.isEmpty()) return 0;
		Set<Character> set = new HashSet<>();
		int i = 0, j = 0, maxLen = 1, len = 1;
		set.add(str.charAt(0));
		for(int p = 1; p < str.length(); p++) {
			j = p;
			while(set.contains(str.charAt(j)) == true) {
				set.remove(str.charAt(i));
				i++;
				len --;
			}
			set.add(str.charAt(j));
			len++;
			if(len > maxLen) maxLen = len;
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		String str = " ";
		System.out.println(lswr(str));
	}

}
