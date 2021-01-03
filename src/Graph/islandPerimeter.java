package Graph;

public class islandPerimeter {
	public int findIslandPerimeter(int[][] mat) {
		int ans = 0;
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] == 1) {
					ans = dfs(mat, i, j);	
				}
			}
		}
		return ans;
	}
	
	public int dfs(int[][] mat, int i, int j) {
		if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] == 0) 
			return 1;
		
		if(mat[i][j] == 2) return 0;
		mat[i][j] = 2; //so that we wont visit same cell again, kind of visited mark
		return dfs(mat, i - 1, j) + dfs(mat, i + 1, j) + dfs(mat, i, j - 1) + dfs(mat, i, j + 1);  
	}
	
	public static void main(String[] args) {
		islandPerimeter ip = new islandPerimeter();
		int[][] mat = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		System.out.println(ip.findIslandPerimeter(mat));
	}
}
