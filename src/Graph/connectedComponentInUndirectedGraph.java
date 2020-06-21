package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class connectedComponentInUndirectedGraph {
	List<List<Integer>> adjList = new ArrayList<>();
	static class Edge{
		int src, destn;
		Edge(int s, int d){
			this.src = s;
			this.destn = d;
		}
	}
	
	public void graph(List<Edge> edges, int v) {
		for(int i = 0; i < v; i++ ) {
			adjList.add(i, new ArrayList<Integer>());
		}
		
		for(Edge e : edges) {
			adjList.get(e.src).add(e.destn);
		}
		
	}
	//time- O(V + E) space- O(h)
	public void dfs(int src, boolean[] visited) {
		System.out.print(src + " ");
		
		for(int vertex : adjList.get(src)) {
			if (visited[vertex] == false) {
				visited[vertex] = true;
				dfs(vertex, visited);
			}
		}
	}
	
	
	public static void main(String[] args) {
		connectedComponentInUndirectedGraph g = new connectedComponentInUndirectedGraph();
		int numVertex = 7;
		g.graph(Arrays.asList(new Edge(0, 1), new Edge(0, 2), new Edge(1, 3), new Edge(0, 4), new Edge(5, 6)), numVertex);
		boolean[] visited = new boolean[numVertex];
		for(int i = 0; i < numVertex; i++ ) {
			if(visited[i] == false) {
				g.dfs(i, visited);
				System.out.println();
			}
		}
		
	}
	

}
