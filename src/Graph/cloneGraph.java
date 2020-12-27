package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class cloneGraph {
	static class Node{
		public int val;
	    public List<Node> neighbors;
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	};
	
	public Node makeDeepCopy(Node node) {
		Map<Node, Node> map = new HashMap<>();
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		map.put(node, new Node(node.val, new ArrayList<>()));
		
		while(!q.isEmpty()) {
			Node temp = q.remove();
			for(Node neighbour : temp.neighbors) {
				if(!map.containsKey(neighbour)) {
					map.put(neighbour, new Node(neighbour.val, new ArrayList<>()));
					q.add(neighbour);
				}
				map.get(temp).neighbors.add(map.get(neighbour));
			}
		}
		return map.get(node);
	}
	
	public void dfs(Node node, boolean[] visited) {
		System.out.print(node.val + " ");
		visited[node.val] = true;
		for(Node nbr : node.neighbors) {
			if(visited[nbr.val] == false) {
				visited[nbr.val] = true;
				dfs(nbr, visited);
			}
		}
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		
		node1.neighbors = Arrays.asList(node2, node4);
		node2.neighbors = Arrays.asList(node1, node3);
		node3.neighbors = Arrays.asList(node2, node4);
		node4.neighbors = Arrays.asList(node1, node3);
		
		cloneGraph cg = new cloneGraph();
//		cg.dfs(node1, new boolean[5]);
		Node cloneNode1 = cg.makeDeepCopy(node1);
		cg.dfs(cloneNode1, new boolean[5]);
	}
	

}
