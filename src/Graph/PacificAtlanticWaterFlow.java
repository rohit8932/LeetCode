package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
	
	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
			
	    if(matrix.length == 0) return res;
		
		
        int[][] pacific = new int[matrix.length][matrix[0].length];
        int[][] atlantic = new int[matrix.length][matrix[0].length];
        
        //for left and right
        for(int row = 0; row < matrix.length; row++) {
        	dfs(matrix, row, 0, Integer.MIN_VALUE, pacific);
        	dfs(matrix, row, matrix[0].length-1, Integer.MIN_VALUE, atlantic);
        }
        
        //top and bottom
        for(int col = 0; col < matrix[0].length; col++) {
        	dfs(matrix, 0, col, Integer.MIN_VALUE, pacific);
        	dfs(matrix, matrix.length-1, col, Integer.MIN_VALUE, atlantic);
        }
        
        for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[0].length; j++) {
        		if(pacific[i][j] == 1 && atlantic[i][j] == 1)
        			res.add(Arrays.asList(i, j));
        	}
        }
        return res;
    }

	public void dfs(int[][] mat, int r, int c, int prev, int[][] ocean) {
		if(r < 0 || c < 0 || r > mat.length-1 || c > mat[0].length -1)
			return;
		if(ocean[r][c] == 1) return;
		
		if(mat[r][c] < prev) return;
		
		ocean[r][c] = 1;
		
		dfs(mat, r - 1, c, mat[r][c], ocean);
		dfs(mat, r + 1, c, mat[r][c], ocean);
		dfs(mat, r, c - 1, mat[r][c], ocean);
		dfs(mat, r, c + 1, mat[r][c], ocean);
	}
	
	public static void main(String[] args) {
		PacificAtlanticWaterFlow leet = new PacificAtlanticWaterFlow();
		List<List<Integer>> ans = leet.pacificAtlantic(new int[][] {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
		for(int i = 0; i < ans.size(); i++) {
			for(int val : ans.get(i)) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
}
