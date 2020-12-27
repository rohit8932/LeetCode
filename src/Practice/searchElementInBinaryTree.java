package Practice;

public class searchElementInBinaryTree {
	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int v){
			this.val = v;
			this.left = null;
			this.right = null;
		}
	}
	
	
	public int search(TreeNode root, int v) {
		if(root == null) return -1;
		if(root.val == v) return root.val;
		
		int temp = search(root.left, v);
		if(temp != -1) return temp;
		else return search(root.right, v);
	}
	
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);				//		   1
		root.left = new TreeNode(2);					//		  /  \
		root.right = new TreeNode(3);					//	     2    3
		root.left.left = new TreeNode(4);				//	   / \   / \
		root.left.right = new TreeNode(5);				//	  4  5  6   7
		root.right.left = new TreeNode(6);				//	
		root.right.right = new TreeNode(7);
		searchElementInBinaryTree seibt = new  searchElementInBinaryTree();
		
		System.out.println(seibt.search(root, 4));
		
		
	}

}
