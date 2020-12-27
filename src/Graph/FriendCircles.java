package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FriendCircles {
	
	public int findCircle(int[][] mat) {
		boolean[] visited = new boolean[mat.length];
		int ans = 0;
		for(int i = 0; i < mat.length; i++) {
			if(visited[i] == false) {
				dfs(i, mat, visited); //we can use either bfs or dfs same ans should come
				ans ++;
			}
		}
		return ans;
	}
	
	public void bfs(int v, int[][] mat, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int temp = q.remove();
			for(int i = 0; i < mat[0].length; i++) {
				if(mat[temp][i] == 1 && visited[i] == false) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
	}
	
	public void dfs(int v, int[][] mat, boolean[] visited) {
		Stack<Integer> s = new Stack<>();
		visited[v] = true;
		s.push(v);
		
		while(s.isEmpty() == false) {
			int temp = s.pop();
			for(int i = 0; i < mat.length; i++) {
				if(mat[temp][i] == 1 && visited[i] == false) {
					visited[i] = true;
					s.push(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[][]mat = {
				{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
				{0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},
				{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},
				{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
				{0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
				{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
				{0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},
				{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
				{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}
				};
		
		FriendCircles fc = new FriendCircles();
		System.out.println(fc.findCircle(mat));
	}
}
