package Practice;

public class BST {
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val){
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	TreeNode root = null;
	public TreeNode addNode(TreeNode root, int val) {
		if(root == null) {
			return new TreeNode(val);
		}
		if(val < root.val) {
			root.left = addNode(root.left, val);
			return root;
		}else {
			root.right = addNode(root.right, val);
			return root;
		}
		
	}

	public TreeNode delete(TreeNode root, int val) {
		if(root == null ) return null;
		
		if(val < root.val) {
			root.left = delete(root.left, val);
			return root;
		}else if(val > root.val) {
			root.right = delete(root.right, val);
			return root;
		}
		
		if(root.left == null && root.right == null) { //case 1
			return null;
		}else if(root.left == null) { //case 2 
			return root.right;
		}else if(root.right == null) { //case 2
			return root.left;
		}else { 						// we will reduce case 3 to either case 1 or 2
			root.val = getSuccessor(root.right).val;
			root.right = delete(root.right, root.val);
			return root;
		}
		
		
		
	}
	
	public TreeNode getSuccessor(TreeNode root) {
		if(root == null) return null;
		while(root.left != null) {
			root = root.left;
		}
		return root;
	}
	public TreeNode search(TreeNode root, int val) {
		if(root == null) return null;
		while(root != null) {
			if(root.val == val) return root;
			if(val < root.val) root = root.left;
			if(val > root.val) root = root.right;
		}
		return null;
	}
	
	public TreeNode getParent(TreeNode root, int val) {
		if(root == null) return null;
		TreeNode parent = null;
		while(root != null) {
			if(val < root.val) {
				parent = root;
				root = root.left;
			}
			else if(val > root.val) {
				parent = root;
				root = root.right;
			}
			else return parent;
		}
		return null;
			
	}
	
	
	
	public void preorder(TreeNode root) {
		if(root != null) {
			System.out.print(root.val + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		BST bst = new BST();
//		TreeNode root = bst.addNode(null, 50);
//		bst.addNode(root, 70);
//		bst.addNode(root, 40);
//		bst.addNode(root, 80);
//		bst.addNode(root, 20);
//		bst.addNode(root, 60);
//		bst.addNode(root, 25);
		
		
		TreeNode root = bst.addNode(null, 50);
		bst.addNode(root, 70);
		bst.addNode(root, 40);
		bst.addNode(root, 80);
		bst.addNode(root, 20);
		bst.addNode(root, 60);
		bst.addNode(root, 25);
		
		bst.preorder(root);
		bst.delete(root, 50);
		System.out.println();
		bst.preorder(root);
	}

}
