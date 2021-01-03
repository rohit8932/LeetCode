package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class floodFill {
	
	public void fillColor(int[][] mat, int x, int y, int newPixel) { //replace old color at x and y
		int oldPixel = mat[x][y];
		boolean[][] visited = new boolean[mat.length][mat[0].length]; //why it was needed? what will happen when oldColor and new Color is same
		bfs(mat, x, y, oldPixel, newPixel, visited);
	}
	
	
	private void dfs(int[][] mat, int x, int y, int oldColor, int newColor, boolean[][] visited) {
		if(x < 0 || x >= mat.length || y < 0 || y >= mat[0].length || mat[x][y] != oldColor) return;
		mat[x][y] = newColor;
		visited[x][y] = true;
		dfs(mat, x + 1, y, oldColor, newColor, visited);
		dfs(mat, x - 1, y, oldColor, newColor, visited);
		dfs(mat, x, y + 1, oldColor, newColor, visited);
		dfs(mat, x, y - 1, oldColor, newColor, visited);
	}
	
	static class Cell{
		int s, d;
		Cell(int s, int d){
			this.s = s;
			this.d = d;
		}
	}
	private void bfs(int[][] mat, int x , int y, int oldColor, int newColor, boolean[][] visited) {
		Cell s = new Cell(x, y);
		Queue<Cell> q = new LinkedList<>();
		q.add(s);
		visited[x][y] = true;
		mat[x][y] = newColor;
		int[] row = {1, -1, 0, 0};
		int [] col = {0, 0, 1, -1};
		while(!q.isEmpty()) {
			Cell temp = q.remove();
			for(int i = 0; i < row.length; i ++) {
				if(isValid(mat, temp.s + row[i], temp.d + col[i], oldColor, visited)) {
					mat[temp.s + row[i]][temp.d + col[i]] = newColor;
					visited[temp.s + row[i]][temp.d + col[i]] = true;
					q.add(new Cell(temp.s + row[i], temp.d + col[i]));
				}
			}
			
		}
	}
	private boolean isValid(int[][] mat, int x, int y, int oldColor, boolean[][] visited) {
		if(x < 0 || x >= mat.length || y < 0 || y >= mat[0].length || mat[x][y] != oldColor || visited[x][y] == true) return false;
		return true;
	}
	
	public static void main(String[] args) {
		floodFill ff = new floodFill();
		int[][] mat = {{1,1,1},{1,1,0},{1,0,1}};
		ff.fillColor(mat, 1, 1, 2);
		
		for(int[] arr : mat) {
			for(int e : arr) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
	}

}
