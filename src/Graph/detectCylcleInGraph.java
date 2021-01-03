package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class detectCylcleInGraph {
	List<List<Integer>> adjLst = new ArrayList<>();
	Map<Integer, Integer> visited = new HashMap<>();
	static class Edge{
		int src, destn;
		Edge(int s, int d){
			this.src = s;
			this.destn = d;
		}
	}
	
	public detectCylcleInGraph(List<Edge> edges, int v) {
		for(int i = 0; i < v; i++) {
			adjLst.add(i,new ArrayList<Integer>());
		}
		for(Edge e : edges) {
			adjLst.get(e.src).add(e.destn);
			visited.put(e.destn, -1);
		}
		
	}
	
	public boolean detectCycleInGraph(int src) {
		visited.put(src, 0);	//0 means in stack, 1 means it is not in stack
		for(int v : adjLst.get(src)) {
			if(visited.get(v) == 0) {
				System.out.println("Graph cotnains cycle");
				return true;
			}
			
			 boolean ret = detectCycleInGraph(v);
			 if(ret == true) return true;
		}
		visited.put(src, 1);
		return false;
	}

	public boolean detectCycleInConnectedGraph(int src, boolean[] visited) {
		visited[src] = true;
		for(int v : adjLst.get(src)) {
			if(visited[v] == false) {
				detectCycleInConnectedGraph(v, visited);
			}else
				return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
//		List<Edge> edges = Arrays.asList(new Edge(0, 2), new Edge(2, 0), new Edge(0, 1), new Edge(1, 2), new Edge(2, 3), new Edge(3, 3));
		List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2), new Edge(2, 3), new Edge(0, 3), new Edge(2, 4));
		detectCylcleInGraph graph = new detectCylcleInGraph(edges, 5);
		System.out.println(graph.detectCycleInGraph(0));
//		System.out.println(graph.detectCycleInConnectedGraph(0, new boolean[5]));
	}
	
	
	
}
