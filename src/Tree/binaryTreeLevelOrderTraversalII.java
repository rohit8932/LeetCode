package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreeLevelOrderTraversalII {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		List<Integer> curr = new ArrayList<>();

		while (!q.isEmpty()) {
			TreeNode temp = q.remove();
			if (temp == null) {
				if (!q.isEmpty()) {
					q.add(null);
					
				}
				ans.add(curr);
				curr = new ArrayList<>();

			} else {
				curr.add(temp.val);
				if (temp.left != null) {
					q.add(temp.left);

				}
				if (temp.right != null) {
					q.add(temp.right);
				}
			}

		}
		Collections.reverse(ans);
		return ans;
	}
	
	public static void main(String[] args) {
		binaryTreeLevelOrderTraversalII btlot = new binaryTreeLevelOrderTraversalII();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		List<List<Integer>> ans = btlot.levelOrderBottom(root);
		for(List<Integer> a : ans) {
			for(int i : a) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
