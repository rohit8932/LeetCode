package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class isGraphValidTree {
	
	public boolean validTree(int n, int[][] edges) {
		List<List<Integer>> adjList = new ArrayList<>();
		int[] parent = new int[n];
		Arrays.fill(parent, -1);
		for(int i = 0; i < n; i++) {
			adjList.add(i, new ArrayList<Integer>());
		}
		
		for(int i = 0; i < edges.length; i++) {
			adjList.get(edges[i][0]).add(edges[i][1]);
			adjList.get(edges[i][1]).add(edges[i][0]);
//			parent[edges[i][1]] = edges[i][0];
		}
		
		boolean[] visited = new boolean[n];
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				if(DFS_undirected(adjList, i, visited, -1) == false) return false;
				
			}
		}
		for(int i = 0; i < n; i++) {
			if(visited[i] == false  )
				return false;
		}
		return true;
		
	}
	
	
	private boolean DFS_undirected(List<List<Integer>> adjList, int src, boolean[] visited, int parent) {
		visited[src] = true;
		
		for(int v : adjList.get(src)) {
			if(visited[v] == false) {
				if(DFS_undirected(adjList, v, visited, src) == false) return false;
				
			}else {
				if(v != parent) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	
	public static void main(String[] args) {
		isGraphValidTree VT = new isGraphValidTree();
//		System.out.println(VT.validTree(5, new int[][] {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}}));
//		System.out.println(VT.validTree(5, new int[][] {{0,1}, {0,2}, {0,3}, {1,4}}));
//		System.out.println(VT.validTree(5, new int[][] {{1,0}, {0,2}, {0,3}, {3,4}}));
//		System.out.println(VT.validTree(5, new int[][] {{1,0}, {0,2}, {2,1}, {0,3}, {3,4}}));
		
		int[][] arr = {{1,0}, {0,2}, {2,1}, {0,3}, {3,4}};
		Arrays.sort(arr, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

		for(int[] e : arr) {
			System.out.println(e[0] + " ");
		}
		
		
	}
	
	

}
