package DP;

public class EditDistance {
	public int editDistance(String str1, String str2, int i, int j) {
		if(i == 0 && j != 0) {
			return j;
		}
		
		if(i != 0 && j == 0) {
			return i;
		}
		
		if(i < 0 || j < 0) return 0;
		if(str1.charAt(i) == str2.charAt(j)) {
			return editDistance(str1, str2, i - 1, j - 1);
		}else {
			int a = editDistance(str1, str2, i, j - 1); //delete
			int b = editDistance(str1, str2, i - 1, j); //
			int c = editDistance(str1, str2, i - 1, j - 1);//substitute
			
			return Math.min(a, Math.min(b, c)) + 1;
		}
		
	}
	
	public int editDistance_DP(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][] mem = new int[m + 1][n + 1];
		for(int r = 0; r < n; r++) { // one of string is empty
			mem[0][r] = r;
		}
		
		for(int c = 0; c < m; c++) { // one of the string is empty
			mem[c][0] = c;
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
					mem[i][j] = mem[i - 1][j - 1];
				}else {
					mem[i][j] = Math.min(mem[i - 1][j], Math.min(mem[i][j - 1], mem[i - 1][j - 1])) + 1;
				}
			}
		}
		return mem[m][n];
		
	}
	
	public static void main(String[] args) {
		EditDistance ed = new EditDistance();
		String s1 = "SUNDAY";
		String s2 = "SATURDAY";
		System.out.println(ed.editDistance(s1, s2, s1.length() - 1, s2.length() - 1));
		System.out.println(ed.editDistance_DP(s1, s2));
	}

}
