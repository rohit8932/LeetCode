package other;

public class PrintAllCombinatationOfString {
	
	public void combination(String str) {
		
		combinationUtil(0, str, new StringBuilder());
	}
	private void combinationUtil(int start, String str, StringBuilder output) {
		for(int i = start; i < str.length(); i++) {
			output.append(str.charAt(i));
			System.out.println(output);
			if(i < str.length()) {
				combinationUtil(i + 1, str, output);
			}	
			output.setLength(output.length() - 1);
		}
	}
	
	public static void main(String[] args) {
		PrintAllCombinatationOfString comb = new PrintAllCombinatationOfString();
		comb.combination("abc");
		
	}

}
