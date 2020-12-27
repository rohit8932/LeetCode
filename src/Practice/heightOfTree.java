package Practice;

public class heightOfTree {
	static class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(int v){
			this.val = v;
			this.left = null;
			this.right = null;
		}
	}
	
	
	public int height(TreeNode root) {
		if(root == null) return 0;
		
		int lh = height(root.left);
		int rh = height(root.right);
		
		return Math.max(lh, rh) + 1;
		
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);				//		   1
		root.left = new TreeNode(2);					//		  /  \
		root.right = new TreeNode(3);					//	     2    3
		root.left.left = new TreeNode(4);				//	   / \   / \
		root.left.right = new TreeNode(5);				//	  4  5  6   7
		root.right.left = new TreeNode(6);				//	
		root.right.right = new TreeNode(7);
		heightOfTree hot = new heightOfTree();
		System.out.println(hot.height(root));
	}

}
