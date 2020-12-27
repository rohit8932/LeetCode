package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class verticalOrderTree {
	
	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int v){
			this.val = v;
			this.left = null;
			this.right = null;
		}
	}
	
	
	public void traverseVerically(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		q.add(root);
		int hd = 0;
		map.put(hd, new ArrayList<>(root.val));
		while(!q.isEmpty()) {
			TreeNode temp = q.remove();
			for(TreeNode u : q) {
				if(u.left != null) {
					q.add(u.left);
					if(map.containsKey(u.left.val) == false) {
//						map.put(map.get, arg1);
					}else {
						
					}
				}
				if(u.right != null) {
					q.add(u.right);
				}
			}
		}
		
		//output
		
		
	}
	
	public Map<Integer, List<Integer>> traverseVertically_preorder(TreeNode root, int hd, Map<Integer, List<Integer>> map) {
		if(root != null) {
			if(map.containsKey(hd) ==false) {
				map.put(hd, new ArrayList<Integer>() {{add(root.val);}});
			}else {
				List<Integer> temp = map.get(hd);
				temp.add(root.val);
				map.put(hd, temp);
			}
			traverseVertically_preorder(root.left, hd - 1, map);
			traverseVertically_preorder(root.right, hd + 1, map);
			return map;
		}
		return map;
	}
	
	public static void main(String[] args) {
		verticalOrderTree vot = new verticalOrderTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		Map<Integer, List<Integer>> ans= vot.traverseVertically_preorder(root, 0, new TreeMap<Integer, List<Integer>>());
		
		for(Map.Entry<Integer, List<Integer>> entry : ans.entrySet()) {
			for(int i : entry.getValue()) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		List<List<Integer>> ro = new ArrayList<>();
		ro.add(0, new ArrayList<Integer>());
		
		
	}
	

}
