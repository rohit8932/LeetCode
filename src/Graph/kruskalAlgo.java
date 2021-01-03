package Graph;

import java.util.Arrays;

public class kruskalAlgo {
	/*Kruskal algo is used in finding MST(Minimum spanning tree : spanning means subgraph in which u visit visit all vertices 
	 * basically i can call call it as tree)
	 * Logic: u sort edges wrt weight of edge, then pick one by one and check weather the picked edge is not making cycle, if not add in ans, 
	 * we only pick V-1 edges, since if we have V vertices it will take V-1 edge to connect with all vertices
	 *  */
	
	static class Edge implements Comparable<Edge>{
		int src, destn, weight;
		Edge(int s, int d, int w){
			this.src = s;
			this.destn = d;
			this.weight = w;
		}
		public int compareTo(Edge e) {
			return this.weight - e.weight;

		}
		
	};
	public void kruskal(Edge[] edges, int v) {
		int[] parent = new int[v];
		int k = 0;
		Edge[] ans = new Edge[v - 1];
		Arrays.sort(edges);
		for(int i = 0; i < v; i++) {
			parent[i] = i;
		}
		
		
		
		for(int i = 0; i < edges.length; i ++) {
			Edge temp = edges[i];
			int src_parent = find(temp.src, parent);
			int destn_Parent = find(temp.destn, parent);
			if(src_parent != destn_Parent) {
				ans[k++] = temp;
				parent[temp.destn] = src_parent;
			}
		}
		
		
		for(int i = 0; i < v - 1; i++) {
			System.out.println(ans[i].src + " --> " + ans[i].destn + " = " + ans[i].weight);
		}
	}
	
	private int find(int src, int[] parent) {
		if(parent[src] == src) return src;
		return find(parent[src], parent);
	}
	
	public static void main(String[] args) {
		kruskalAlgo ka = new kruskalAlgo();
		Edge[] edges = {new Edge(0, 1, 1), new Edge(1, 2, 5), new Edge(0, 2, 3)};
		ka.kruskal(edges, 3);
	}

}
