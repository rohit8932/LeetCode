package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	static class Edge{
		int src, destn;
		Edge(int s, int d){
			this.src = s;
			this.destn = d;
		}
	}
	
	List<List<Integer>> adjList = new ArrayList<>();
	BFS(List<Edge> edges, int numVertex){
		for(int i = 0 ; i < numVertex; i ++) {
			adjList.add(i, new ArrayList<Integer>());
		}
		for(Edge e : edges) {
			adjList.get(e.src).add(e.destn);
		}
		
	}
	
	
	public void bfs_iterative(int src) {
		Queue<Integer> q = new LinkedList<>();
		List<Integer> visited = new ArrayList<>();
		q.add(src);
		visited.add(src);
		while(!q.isEmpty()) {
			int temp = q.remove();
			System.out.print(temp + " ");
			for(int v : adjList.get(temp)) {
				if(visited.contains(v) == false) {
					q.add(v);
					visited.add(v);
				}
			}
		}
		
	}
	
	public void bfs_matrix(int[][] mat, int src) {
		boolean[] visited = new boolean[mat.length];
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		visited[src] =true;
		while(!q.isEmpty()) {
			int temp = q.remove();
			System.out.print(temp + " ");
			for(int i = 0; i < mat.length; i++) {
				if(mat[temp][i] > 0 && visited[i] == false) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(new Edge(0, 1),new Edge(0, 3), new Edge(1, 2), new Edge(1, 3),new Edge(2, 3));
		BFS bfs = new BFS(edges, 4);
//		bfs.bfs_iterative(0);
		
		
		int[][] graph = {
				   {0, 1, 1, 1, 0, 0},
				   {1, 0, 0, 1, 1, 0},
				   {1, 0, 0, 1, 0, 1},
				   {1, 1, 1, 0, 1, 1},
				   {0, 1, 0, 1, 0, 1},
				   {0, 0, 1, 1, 1, 0}
				};
        bfs.bfs_matrix(graph, 0);
		
	}

}
