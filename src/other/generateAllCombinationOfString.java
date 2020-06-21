package other;

import java.awt.Checkbox;

public class generateAllCombinationOfString {
	
	public static void allPossibleCombination(String str) {
		for(int i = 0; i < str.length(); i++) {
			for(int j = i; j < str.length(); j++) {
				System.out.println(str.substring(i, j + 1));
			}
		}
	}
	
	//problem: find all substring in string which is palindrome
	//sol: generate all possible combination and check each combination for palindrome
	public static int numPalindromeInSubstring_brute(String str) {
		int numPalindrome = 0;
		for(int i = 0; i < str.length(); i++) {
			for(int j = i; j < str.length(); j++) {
				if(isPalindrome(str.substring(i, j + 1))) numPalindrome ++;
			}
		}
		return numPalindrome;
	}
	
	private static boolean isPalindrome(String str) {
		for(int i = 0; i < (str.length() / 2); i++) {
			if(!(str.charAt(i) == str.charAt(str.length() - 1 - i))) return false;
		}
		return true;
	}
	
	public static int numPalindromeInSubstring_optimized(String str) {
		int numPalindrome = 0;
		for(int i = 0; i < str.length(); i++) {
			numPalindrome += checkPalindrome(str, i, i);
			numPalindrome += checkPalindrome(str, i, i + 1);
			
			
		}
		return numPalindrome;
		
	}
	private static int checkPalindrome(String str, int left, int right) {
		int numPalindrome = 0;
		while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
			left --;
			right ++;
			numPalindrome++;
		}
		
		return numPalindrome;
	}
	
	public static void main(String[] args) {
		System.out.println(numPalindromeInSubstring_brute("aaa"));
		System.out.println(numPalindromeInSubstring_optimized("aaa"));
	}

}
