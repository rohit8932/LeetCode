package DP;

public class minPathSum {
	/* this is matrix problem, reach bottom right from top left, minimum cost */
	
	public int minPath(int[][] mat, int i, int j) {
		if(i == mat.length - 1 && j == mat[0].length - 1) return mat[i][j];
		
		int temp = Integer.MAX_VALUE;
		if(i + 1 < mat.length && j < mat[0].length) {
			temp = minPath(mat, i + 1, j) + mat[i][j];
		}
		if(i < mat.length && j + 1< mat[0].length) {
			temp = Math.min(temp, minPath(mat, i, j + 1) + mat[i][j]);
		}
		
		return temp;
	}
	
	public int minPath_DP(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		//1st row, you only have one option, to get from right not from top 
		for(int i = 1; i < n; i++) {
			mat[0][i] = mat[0][i - 1] + mat[0][i];
		}
		
		//1st column, you only have one option, to get from top not from right
		for(int i = 1; i < m; i++) {
			mat[i][0] = mat[i - 1][0] + mat[i][0];
		}
		
		for(int i = 1; i < m; i ++) {
			for(int j = 1; j < n; j++) {
				mat[i][j] = Math.min(mat[i - 1][j], mat[i][j - 1]) + mat[i][j];
				
			}
		}
		
		return mat[m - 1][n - 1];
		
	}
	
	
	
	public static void main(String[] args) {
		minPathSum mps = new minPathSum();
		int[][] mat = {{1, 3, 1},
					  {1, 5, 1},
					  {4, 2, 1}};
		System.out.println(mps.minPath(mat, 0, 0));
		System.out.println(mps.minPath_DP(mat));
	}

}
