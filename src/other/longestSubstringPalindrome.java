package other;

public class longestSubstringPalindrome {
	
	
	public static String longestPalindrome(String s) {
		if(s == null || s.length() < 1) return "";
		
		String currString = "";
		String maxString = "";
		for(int i = 0; i < s.length(); i++) {
			currString = expandFromMiddle(s, i, i);
			if(currString.length() > maxString.length()) {
				maxString = currString;
			}
			
			currString= expandFromMiddle(s, i, i + 1);
			if(currString.length() > maxString.length()) {
				maxString = currString;
			}
		}
		return maxString;
	}
	
	
	private static String expandFromMiddle(String s, int left, int right) {
		if(s == null || left > right) return "";
		
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left --;
			right ++;
		}
		//remember while doing -- or ++ we r not verifying for that index(after inc,dec) so when done,
		//we increment the left and decrement the right
		//subString works on index [beg, end) so no need to decrement the right
		return s.substring(left + 1, right);
		
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("cbbd"));
	}

}
