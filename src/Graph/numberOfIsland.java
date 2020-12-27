package Graph;

public class numberOfIsland {
	
	public int numOfIsland(int[][] mat) {
		int ans = 0;
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] == 1) {
					dfs(mat, i, j);
					ans ++;
				}
			}
		}
		return ans;
	}
	
	
	private void dfs(int[][] mat, int i, int j) {
		if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] == 0) return;
		mat[i][j] = 0;
		
		dfs(mat, i - 1, j);
		dfs(mat, i, j + 1);
		dfs(mat, i + 1, j);
		dfs(mat, i, j - 1);
	}
	
	public static void main(String[] args) {
		numberOfIsland noi = new numberOfIsland();
		int[][] mat = {
				{1, 1, 0, 0, 0},
				{1, 1, 0, 0, 0},
				{0, 0, 1, 0, 0},
				{0, 0, 0, 1, 1}
		};
		
		System.out.println(noi.numOfIsland(mat));
	}
}
