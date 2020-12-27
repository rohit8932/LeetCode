package Practice;

import java.util.HashSet;

public class Permute {
	private HashSet<String> hs = new HashSet<>();
	
	public void permute(StringBuffer str, int i) {
		if (i >= str.length() - 1) {
			if (checkPalindrome(str)) {
				if(hs.contains(str.toString()) == false) {
					hs.add(new String(str));
					System.out.println(str);
				}
			}
			return;
		}
		
		for(int k = i; k < str.length(); k++) {
			swap(str, i, k);
			permute(str, i + 1);
			swap(str, k, i);
		}
	}
	
	private boolean checkPalindrome(StringBuffer str) {
		for(int i = 0, j = str.length() - 1; i < str.length() / 2; i ++, j --) {
			if(str.charAt(i) != str.charAt(j)) return false;
		}
		return true;
	}
	
	
	private void swap(StringBuffer str, int i, int j) {
		String temp = str.substring(i, i + 1);
		str.replace(i, i + 1, str.substring(j, j + 1));
		str.replace(j, j + 1, temp);
		
		
	}
	
	public static void main(String[] args) {
		Permute per = new  Permute();
		per.permute(new StringBuffer("aabbcadad"), 0);
	}

}
