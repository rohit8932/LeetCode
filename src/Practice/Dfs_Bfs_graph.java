package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Dfs_Bfs_graph {
	
	public void bfs(int[][] mat, int v) {
		Queue<Integer> q = new LinkedList<>();
		boolean[]visited = new boolean[mat.length];
		q.add(v);
		visited[v] = true;
		while(!q.isEmpty()) {
			int temp = q.remove();
			System.out.print(temp + " ");
			for(int i = 0;i < mat[0].length; i ++) {
				if(mat[temp][i] == 1 && visited[i] == false) {
					q.add(i);
					visited[i]= true;
				}
			}
		}
	}
	
	public void dfs(int[][] mat, int v) {
		Stack<Integer> st = new Stack<>();
		boolean[] visited = new boolean[mat.length];
		st.push(v);
		visited[v] = true;
		while(!st.isEmpty()) {
			int temp = st.pop();
			System.out.print(temp + " ");
			for(int i = 0; i < mat[0].length; i++) {
				if(mat[temp][i] == 1 && visited[i] == false) {
					st.push(i);
					visited[i] = true;
				}
			}
		}
		
	}
	
	public void dfs_recursive(int[][] mat, int v, boolean[] visited) {
		System.out.print(v + " ");
		visited[v] = true;
		for(int i = 0; i < mat[0].length; i++) {
			if(mat[v][i] == 1 && visited[i] == false) {
				visited[i] = true;
				dfs_recursive(mat, i, visited);
			}
		}
	}
	
	static class Edge{
		int src, destn;
		Edge(int s, int d){
			this.src = s;
			this.destn =d;
		}
	}
	
	List<List<Integer>> graph = new ArrayList<>();
	public void makeGraph(List<Edge> edges, int v) {
		for(int i = 0; i < v; i++) {
			graph.add(i, new ArrayList<Integer>());
		}
		
		for(Edge e : edges) {
			graph.get(e.src).add(e.destn);
		}
		
	}
	
	public void dfs_adjList(int v, boolean[] visited) {
		System.out.print(v + " ");
		visited[v] = true;
		for(int nbr : this.graph.get(v)) {
			if(visited[nbr] == false) {
				dfs_adjList(nbr, visited);
			}
		}
	}
	
	public void topologicalSort(List<List<Integer>> graph, int v) {
		boolean[] visited = new boolean[v];
		Stack<Integer> ans = new Stack<>();
		for(int i = 0; i < v; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				ans = dfs(graph, i, ans, visited);
			}
		}
		
		while(!ans.isEmpty()) {
			System.out.print(ans.pop() + " ");
		}
		
	}

	private Stack<Integer> dfs(List<List<Integer>> graph, int vtx, Stack<Integer> ans, boolean[] visited) {
		for(int n : graph.get(vtx)) {
			if(visited[n] == false) {
				visited[n] = true;
				dfs(graph, n, ans, visited);
			}
		}
		ans.add(vtx);
		return ans;
	}
	
	public boolean detectCycle(int v) {
		boolean[] visited = new boolean[v];
		boolean[] helper = new boolean[v];
		for(int i = 0; i < v; i++) {
			if(visited[i] == false) {
				boolean ans = dfsCycle(i, visited, helper);
				if(ans == true) return true;
			}
		}
		return false;
		
	}
	
	private boolean dfsCycle(int v, boolean[] visited, boolean[] helper) {
		visited[v] = true;
		helper[v] = true;
		for(int n : graph.get(v)) {
			if(visited[n] == false) {
				boolean ans = dfsCycle(n, visited, helper);
				if(ans == true) return true;
			}else {
				if(helper[n] == true) return true;
			}
		}
		helper[v] = false;
		return false;
	}
	
	
	public static void main(String[] args) {
		int[][] mat = {
				{0, 1, 0, 0, 1, 0},
				{1, 0, 1, 0, 0, 1},
				{0, 1, 0, 1, 1, 0},
				{0, 0, 1, 0, 0, 1},
				{1, 0, 1, 0, 0, 1},
				{0, 1, 1, 1, 1, 0}
				};
		Dfs_Bfs_graph g = new Dfs_Bfs_graph();
//		g.bfs(mat, 0);
//		g.dfs(mat, 0);
//		g.dfs_recursive(mat, 0, new boolean[mat.length]);
//		g.makeGraph(Arrays.asList(new Edge(0, 1), new Edge(1, 2), new Edge(2, 3), new Edge(1, 0), new Edge(1, 3) ),   4);
//		g.dfs_adjList(0, new boolean[4]);
		
		g.makeGraph(Arrays.asList(new Edge(0, 1), new Edge(1, 2), new Edge(2, 4), new Edge(4, 5), new Edge(1, 3), new Edge(3, 4)), 6);
//		g.topologicalSort(g.graph, 6);
		System.out.println(g.detectCycle(6));
		
	}

}
