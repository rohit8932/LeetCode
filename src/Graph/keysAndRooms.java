package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class keysAndRooms {
	
	
	public boolean dfs(List<List<Integer>> adjMat) {
		boolean[] visited = new boolean[adjMat.size()];
		Stack<Integer> s = new Stack<>();
		s.push(0);
		visited[0] = true;
		
		while(!s.isEmpty()) {
			int temp = s.pop();
			for(int e : adjMat.get(temp)) {
				if(visited[e] == false) {
					visited[e] = true;
					s.push(e);
				}
			}
		}
		
		for(int i = 0; i < visited.length; i++) {
			if(visited[i] == false) return false;
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		keysAndRooms kar = new keysAndRooms();
		List<List<Integer>> adjMat = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			adjMat.add(i, new ArrayList<>());
		}
		adjMat.get(0).add(1);
		adjMat.get(1).add(2);
		adjMat.get(2).add(3);
		System.out.println(kar.dfs(adjMat));
	}

}
