package DP;

public class LCS {
	
	public int LCS_Recursive(String s1, String s2, int i, int j) {
		if(i < 0 || j < 0 ) return 0;
		
		if(s1.charAt(i)== s2.charAt(j)) {
			return 1 + LCS_Recursive(s1, s2, i - 1, j - 1);
		}
		
		return Math.max(LCS_Recursive(s1, s2, i - 1, j), LCS_Recursive(s1, s2, i, j - 1));
		
	}
	
	public int LCS_DP(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] mem = new int[m + 1][n + 1];
		
		for(int i = 0; i < n; i ++) { //first row zero, LCS of string of length 0 and string s2
			mem[0][i] = 0;
		}
		for(int i = 0; i < m; i++) { //first col zero, LCS of string s1 and string s2 of length 0
			mem[i][0] = 0;
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					mem[i][j] = mem[i - 1][j - 1] + 1;
				}else {
					mem[i][j] = Math.max(mem[i - 1][j], mem[i][j - 1]);
				}
			}
		}
		return mem[m][n];
		
	}
	
	
	public static void main(String[] args) {
		LCS lcs = new LCS();
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		System.out.println(lcs.LCS_Recursive(s1, s2, s1.length() - 1, s2.length() - 1));
		System.out.println(lcs.LCS_DP(s1, s2));
	}

}
