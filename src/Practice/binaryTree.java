package Practice;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class binaryTree {
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	TreeNode root = null;
	
	public void buildTree(TreeNode root, int val) {
		if(this.root == null) {
			this.root = new TreeNode(val);
			return;
		}
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode temp = q.remove();
			if(temp.left != null) {
				q.add(temp.left);
			}else {
				temp.left = new TreeNode(val);
				return;
			}
			
			if(temp.right != null) {
				q.add(temp.right);
			}else {
				temp.right = new TreeNode(val);
				return;
			}
		}
	}
	
	public void preorderRecursive(TreeNode root) {
		if(root != null) {
			System.out.print(root.val + " ");
			preorderRecursive(root.left);
			preorderRecursive(root.right);
		}
	}
	
	public void inorderRecursive(TreeNode root) {
		if(root != null) {
			inorderRecursive(root.left);
			System.out.print(root.val + " ");
			inorderRecursive(root.right);
		}
	}
	
	public void postorderRecursive(TreeNode root) {
		if(root != null) {
			postorderRecursive(root.left);
			postorderRecursive(root.right);
			System.out.print(root.val + " ");
		}
	}
	
	public void levelorder(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode temp = q.remove();
			System.out.print(temp.val +  " ");
			if(temp.left != null) q.add(temp.left);
			if(temp.right != null) q.add(temp.right);
		}
	}
	
	
	public void preorderIterative(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		
		while(!s.isEmpty()) {
			TreeNode temp = s.pop();
			System.out.print(temp.val + " ");
			if(temp.right != null) s.push(temp.right);
			if(temp.left != null) s.push(temp.left); 
		}
		
	}
	
	
	public void inorderIterative(TreeNode root) {
		Stack<TreeNode> st = new Stack<binaryTree.TreeNode>();
		while(true) {
			while(root != null) {
				st.push(root);
				root = root.left;
			}
			if(st.isEmpty()) break;
			TreeNode temp = st.pop();
			System.out.print(temp.val + " ");
			root = temp.right;
		}
		
		
	}
	
	static int preIndex = 0;
	public TreeNode buildTreeFromPreorderInorder(int[] pre, int[] in, int inLow, int inHigh) {
		if(inLow > inHigh) return null;
		
		TreeNode root = new TreeNode(pre[preIndex]);
		int temp = search(in, pre[preIndex]);
		preIndex ++;
		root.left = buildTreeFromPreorderInorder(pre, in, inLow, temp - 1);
		root.right = buildTreeFromPreorderInorder(pre, in, temp + 1, inHigh);
		return root;
	}
	
	private int search(int[] pre, int val) {
		for(int i = 0; i < pre.length; i++) {
			if(pre[i] == val) return i;
		}
		return -1;
	}
	
	public void printAllAnchestorOfTree(TreeNode root, int[] arr, int i) {
		if(root != null) {
		if(root.left == null && root.right == null) {
			arr[i] = root.val;
			print(arr, i + 1);
			return;
		}
		
		arr[i] = root.val;
		printAllAnchestorOfTree(root.left, arr, i + 1);
		printAllAnchestorOfTree(root.right, arr, i + 1);
		}
	}
	private void print(int[] arr, int i) {
		for(int j = 0; j < i; j ++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}
	
	
	//time= O(n^2) space- O(n)
	public int diameter(TreeNode root) {
		if(root == null) return 0;
		
		int lheight = height(root.left);
		int rheight = height(root.right);
		
		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);
		
		return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
	}
	
	public int height(TreeNode root) {
		if(root == null) return 0;
		
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	static class Height{
		int h;
	}
	public int diameter_optimized(TreeNode root, Height height) {
		if(root == null) {
			height.h = 0;
			return 0;
		}
		
		Height lh = new Height(), rh = new Height();
		int ldiameter= diameter_optimized(root.left, lh);
		int rdiameter= diameter_optimized(root.right, rh);
		
		height.h = 1 + Math.max(lh.h, rh.h);
		return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
	}
	
	public void verticalSumInBinaryTree(TreeNode root, int col, Map<Integer, Integer> map) {
		if(root == null) return;
		verticalSumInBinaryTree(root.left, col - 1, map); 
		verticalSumInBinaryTree(root.right, col + 1, map);
		map.put(col, map.getOrDefault(col, 0) + root.val);
		
	}
	
	
	public static void main(String[] args) {
		binaryTree bt = new binaryTree();
		bt.buildTree(bt.root, 1); //`	`				1
		bt.buildTree(bt.root, 2); //				   /  \
		bt.buildTree(bt.root, 3); //				  2    3 
		bt.buildTree(bt.root, 4); //			     / \   /
		bt.buildTree(bt.root, 5); //                4   5 6
		bt.buildTree(bt.root, 6);
		
//		bt.preorderRecursive(bt.root);
//		bt.inorderRecursive(bt.root);
//		bt.postorderRecursive(bt.root);
//		bt.levelorder(bt.root);
//		System.out.println();
//		bt.preorderIterative(bt.root);
//		System.out.println();
//		bt.inorderIterative(bt.root);
		
//		int[] pre = new int[] {50, 40, 45, 80, 60, 90};
//		int[] in = new int[] {40, 45, 50, 60, 80, 90};
//		TreeNode newRoot = bt.buildTreeFromPreorderInorder(pre, in, 0, 5);
//		bt.preorderRecursive(newRoot);
		
//		bt.printAllAnchestorOfTree(bt.root, new int[20], 0);
		
//		Map<Integer, Integer> map = new HashMap<>();
//		bt.verticalSumInBinaryTree(bt.root, 0, map);
//		for(int k : map.keySet()) {
//			System.out.println(k + " "  + map.get(k));
//		}
		
//		System.out.println(bt.diameter(bt.root));
		System.out.println(bt.diameter_optimized(bt.root, new Height()));
	}

}
