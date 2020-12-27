package Practice;

import Practice.heightOfTree.TreeNode;

public class createMirrorOfBinaryTree {
	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int v){
			this.val = v;
			this.left = null;
			this.right = null;
		}
	}
	
	public TreeNode createMirror(TreeNode root) {
		if(root == null) return null;
		
		TreeNode newRoot = new TreeNode(root.val);
		newRoot.right = createMirror(root.left);
		newRoot.left = createMirror(root.right);
		return newRoot;
	}
	
	public void preorder(TreeNode root) {
		if(root != null) {
			System.out.print(root.val + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public boolean checkMirror(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null) return true;
		if(root1 == null || root2 == null) return false;
		
		return (root1.val == root2.val && checkMirror(root1.left, root2.right) && checkMirror(root1.right, root2.left));
	}
	
	public TreeNode LCA(TreeNode root, int node1, int node2) { //this is will not handle case when two node is parent and child relation
		if(root == null) return null;
		if(root.val == node1 || root.val == node2) return root;
		
		TreeNode left = LCA(root.left, node1, node2);
		TreeNode right = LCA(root.right, node1, node2);
		
		if(left != null && right != null) return root;
		if(left != null ) return left;
		return right;
		
	}
	
	static boolean v1 = false, v2 = false;
	public TreeNode LCA_2(TreeNode root, int node1, int node2) {
		if(root == null) return root;
		TreeNode temp = null;
		if(root.val == node1) {
			temp = root;
			v1 = true;
		}
		if(root.val == node2) {
			temp = root;
			v2 = true;
		}
		
		TreeNode left = LCA_2(root.left, node1, node2);
		TreeNode right = LCA_2(root.right, node1, node2);
		
		if(temp != null) return temp;
		
		if(left != null && right != null) return root;
		if(left != null) return left;
		return right;
		
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);				//		   1
		root.left = new TreeNode(2);					//		  /  \
		root.right = new TreeNode(3);					//	    2    3
		root.left.left = new TreeNode(4);				//	   / \   / \
		root.left.right = new TreeNode(5);				//	  4  5  6   7
		root.right.left = new TreeNode(6);				//	
		root.right.right = new TreeNode(7);
		
		createMirrorOfBinaryTree cmobt = new createMirrorOfBinaryTree();
		TreeNode newRoot = cmobt.createMirror(root);
//		cmobt.preorder(newRoot);
//		System.out.println(cmobt.checkMirror(root, root));
		TreeNode lcaNode = cmobt.LCA(root, 6, 7);
//		System.out.println("LCA Node " + lcaNode.val);
		
		TreeNode lcaNode_2 = cmobt.LCA_2(root, 2, 10);
		if(v1 && v2) {
			System.out.println("LCA Node " + lcaNode_2.val);
		}else {
			System.out.println("Node is not present in tree");
		}
	}
	

}
