package Graph;

import java.util.ArrayList;
import java.util.List;

public class allPathfromSourceToDestn {
	
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(graph, 0, graph.length -1, ans, curr);
        return ans;
    }
    
    
    
    public void dfs(int[][] graph, int s, int d, List<List<Integer>> ans, List<Integer> curr){
        curr.add(   s);
        if(s == d){
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i : graph[s]){
            dfs(graph, i, d, ans, curr);
            curr.remove(curr.size() - 1);
        }
        
    }
    
    public static void main(String[] args) {
		allPathfromSourceToDestn lpfstd = new allPathfromSourceToDestn();
		int[][] graph = {{1,2},{3},{3},{}};
		List<List<Integer>> ans = lpfstd.allPathsSourceTarget(graph);
		
		for(List<Integer> i : ans) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

}
