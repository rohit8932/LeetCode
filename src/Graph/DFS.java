package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DFS {
	List<List<Integer>> adjList = new ArrayList<>(); 
	static class Edge{
		int src, destn;
		Edge(int s, int d){
			this.src = s;
			this.destn = d;
		}
	}
	
	DFS(List<Edge> edges, int numV){
		for(int i = 0; i < numV; i++) {
			adjList.add(i, new ArrayList<>());
		}
		
		for(Edge e : edges) {
			adjList.get(e.src).add(e.destn);
		}
	}
	
	
	public void dfsRecursive(int src, boolean[] visited) {
		visited[src] = true;
		System.out.print(src + " ");
		for(int v : adjList.get(src)) {
			if(visited[v] == false)
				dfsRecursive(v, visited);
		}
		
	}
	
	public void dfsStack(int src, boolean[] visited) {
		Stack<Integer> s = new Stack<>();
		s.add(src);
		visited[src] = true;
		while(!s.empty()) {
			int temp = s.pop();
			System.out.print(temp + " ");
			for(int v : adjList.get(temp)) {
				if(visited[v] == false) {
					s.add(v);
					visited[v] = true;
				}
			}
		}
	}
	
	public void dfs_recirsiveMatrix(int[][] mat, int src, boolean[] visited) {
		System.out.print(src + " ");
		visited[src] = true;
		for(int i = 0; i < mat.length; i++) {
			if(mat[src][i] == 1 && visited[i] == false) {
				dfs_recirsiveMatrix(mat, i, visited);
			}
		}
		
	}
	
	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2), new Edge(2, 3), new Edge(2, 1));
		int numVertex = 4;
		DFS d = new DFS(edges, numVertex);
 		
//		d.dfsRecursive(0, new boolean[numVertex]);
//		System.out.println();
//		d.dfsStack(0, new boolean[numVertex]);
		
		
		int[][] graph = {
				   {0, 1, 1, 1, 0, 0},
				   {1, 0, 0, 1, 1, 0},
				   {1, 0, 0, 1, 0, 1},
				   {1, 1, 1, 0, 1, 1},
				   {0, 1, 0, 1, 0, 1},
				   {0, 0, 1, 1, 1, 0}
				};
		
		d.dfs_recirsiveMatrix(graph, 0, new boolean[graph.length]);
		
		
	}
	

}
