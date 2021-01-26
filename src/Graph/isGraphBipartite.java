package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class isGraphBipartite {
	//what is bipartite?
	/*if u can divide graph into sets such that there is edge from one set to another set but no edge within same set.
	 * Logic: if current node has blue color mark all neighbor as red, if u find any neighbor with same color as current node
	 * that means we cannot have bipartite
	 * */
	
	//time- O(E) space- O(V)
	public boolean isBipartite(int[][] graph) {
		int[] color = new int[graph.length];
		Queue<Integer> q = new LinkedList<>();

		for (int v = 0; v < graph.length; v++) {
			if(color[v] == 1 || color[v] == -1) continue;
			q.add(v);
			color[v] = 1; // 1 = blue, -1 = Red, 0 = unexplored ie. no color
			
			while (!q.isEmpty()) {
				int temp = q.poll();
				for (int nbr : graph[temp]) {
					if (color[nbr] == 0) {
						q.offer(nbr);
						color[nbr] = -color[temp]; //making color opposite of current node
					} else if (color[nbr] == color[temp]) { //u cannot have neighbor of same color, there is edge and it must src and destn 
						return false;	    																//must belong to seprate group 
					}
				}
			}
		}
		return true;
	}
	
	
	public boolean isBipartite_DFS(int[][] graph, int v, int[] color, int c) {
		if(color[v] != 0 && color[v] == -c) return false; //it is visited, having color opposite of expected,returning false
		color[v] = c;
		
		for (int temp : graph[v]) {
			boolean ans = true;
			if (color[temp] == 0) {
				ans = isBipartite_DFS(graph, temp, color, -c);
			} else if (color[temp] != 0 && color[temp] == c) {
				return false;
			}
			if (ans == false)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		isGraphBipartite igb = new isGraphBipartite();
		int[][] graph = {{1,2,3},{0,2},{0, 1, 3},{0, 2}};
		System.out.println(igb.isBipartite(graph));
		
		System.out.println(igb.isBipartite_DFS(graph, 0, new int[graph.length], 1));
	}
};
