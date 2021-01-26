package DP;

public class uniquePath {
	
	public int findUinquePath(int m, int n, int x, int y) {
		if(x == m -1  && y == n - 1) {
			return 1;
		}
		
		int down = 0;
		if(x + 1 < m) {
			down = findUinquePath(m, n, x + 1, y);
		}
		int right = 0;
		if(y + 1 < n) {
			right = findUinquePath(m, n, x, y + 1);
		}
		
		return down + right;
	}
	
	
	public int findUniquePath_2(int m, int n, int i, int j) {
		if(i == m - 1 && j == n - 1) return 1;
		if(i < 0 || i >= m || j < 0 || j >= n) return 0;
		
		return findUniquePath_2(m, n, i + 1, j) + findUniquePath_2(m, n, i, j + 1);
		
	}

	
	
	public static void main(String[] args) {
		uniquePath up = new uniquePath();
		int[][] mat = new int[3][3];
		System.out.println(up.findUinquePath(3, 7, 0, 0));
		System.out.println(up.findUniquePath_2(3, 7, 0, 0));
	}
}
