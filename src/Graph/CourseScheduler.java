package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduler {
	List<List<Integer>> adjList = new ArrayList<>();
	static class Edge{
		int src, destn, inDegree;
		Edge(int s, int d){
			this.src = s;
			this.destn = d;
			this.inDegree = 0;
		}
	}
	
	public void makeGraph(List<Edge> edges, int V) {
		for(int i = 0; i < V; i++){
			adjList.add(i, new ArrayList<Integer>());
		}
		for(Edge e : edges) {
			adjList.get(e.src).add(e.destn);
		}
	}
	
	
	public boolean removeNode(int[] indegree) {
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < indegree.length; i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		if(q.isEmpty()) return false;
		
		while(!q.isEmpty()) {
			int temp = q.remove();
			for(int i = 0; i < adjList.get(temp).size(); i++) {
				if(--indegree[adjList.get(temp).get(i)] == 0)
					q.add(adjList.get(temp).get(i));
			}
			adjList.get(temp).clear();;
		}
		for(int i = 0; i < adjList.size(); i++) {
			if(adjList.get(i).size() != 0) return false;
		}
		return true;
		
	}
	public static void main(String[] args) {
		List<Edge> edges = new ArrayList<>();
			int[][] edge = {{3,2}, {2,1},{1,0},{2,0}};
		int numNode = 4;
//		int[][] edge = {{}};
		
		for(int i = 0; i < edge.length; i++) {
			edges.add(new Edge(edge[i][1], edge[i][0]));
		}
		CourseScheduler cs = new CourseScheduler();
		cs.makeGraph(edges, numNode);
		//get indegree
		int[] indegree = new int[numNode];
		for(int i = 0; i < cs.adjList.size(); i++) {
			for(int j = 0; j < cs.adjList.get(i).size(); j++) {
				indegree[cs.adjList.get(i).get(j)] ++;
			}
		}
		
		System.out.println(cs.removeNode(indegree));
		
	}
}
