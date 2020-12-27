package Tree;

import Tree.mergeTwoBinaryTree.TreeNode;

public class mergeTwoBinaryTree {
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int v){
			this.val = v;
			this.left = null;
			this.right = null;
		}
	}
	
	
	public TreeNode merge(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null) return null;
		if(t1 == null) return t2;
		if(t2 == null) return t1;
		
		TreeNode temp = new TreeNode(t1.val + t2.val);
		temp.left = merge(t1.left, t2.left);
		temp.right = merge(t1.right, t2.right);
		return temp;
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(3);
		t1.left.right = new TreeNode(4);
		
		TreeNode t2 = new TreeNode(1);
		t2.left = new TreeNode(2);
		t2.right = new TreeNode(3);
		t2.left.left = new TreeNode(5);
		t2.right.left = new TreeNode(4);
		
		mergeTwoBinaryTree mtbt  = new mergeTwoBinaryTree();
		TreeNode newTree = mtbt.merge(t1, t2);
		
		System.out.println(newTree.val);
		System.out.println(newTree.left.val);
		System.out.println(newTree.right.val);
		System.out.println(newTree.left.left.val);
		System.out.println(newTree.left.right.val);
		
		System.out.println(newTree.right.left.val);
		
	}
}
