package other;

public class StringPermutation {
	
	
	public static void permute(StringBuilder str, int i) {
		if(i == str.length() - 1) {
			System.out.println(str);
		}
		
		for(int j = i; j < str.length(); j++) {
			swap(str, i, j);
			permute(str, i + 1);
			swap(str, j, i);
		}
		
	}
	
	private static void swap(StringBuilder str, int i, int j) {
		char temp = str.charAt(i);
		str.setCharAt(i, str.charAt(j));
		str.setCharAt(j, temp);
	}
	
	public static void main(String[] args) {
		permute(new StringBuilder("ABC"), 0);
	}

}
