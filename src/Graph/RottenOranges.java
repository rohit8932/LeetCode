package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
	static class Cell{
		int i, j;
		Cell(int x, int y){
			this.i = x;
			this.j = y;
		}
	}
	public int orangesRotting(int[][] grid) {
		Queue<Cell> q= new LinkedList<>();
		int total = 0, rotten = 0, ans = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 2 || grid[i][j] == 1) total ++;
				if(grid[i][j] == 2) {
					q.add(new Cell(i, j));
				}
			}
		}
		
		if(total == 0) return 0; //when there is no tomatoes we return 0
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				Cell temp = q.remove();
				rotten ++;
				if(isValid(grid, temp.i + 1, temp.j)) {
					q.add(new Cell(temp.i + 1, temp.j));
					grid[temp.i + 1][temp.j] = 2;
				}
				if(isValid(grid, temp.i - 1, temp.j)) {
					q.add(new Cell(temp.i - 1, temp.j));
					grid[temp.i - 1][temp.j] = 2;
				}
				if(isValid(grid, temp.i, temp.j + 1)) {
					q.add(new Cell(temp.i, temp.j + 1));
					grid[temp.i][temp.j + 1] = 2;
				}
				if(isValid(grid, temp.i, temp.j - 1)) {
					q.add(new Cell(temp.i, temp.j - 1));
					grid[temp.i][temp.j - 1] = 2;
				}
				
			}
			ans++;
		}
		
		if(rotten == total) return ans - 1;
		return -1;
		
	}
	
	private boolean isValid(int[][] mat, int x, int y) {
		if(x < 0 || x >= mat.length || y < 0 || y >= mat[0].length || mat[x][y] == 0 || mat[x][y] == 2) return false;
		return true;
	}
	
	public static void main(String[] args) {
		RottenOranges ro = new RottenOranges();
		int[][] mat = {{2,1,1},{0,1,1},{1,0,1}};
		System.out.println(ro.orangesRotting(mat));
	}

}
