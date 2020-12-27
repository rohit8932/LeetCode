package Tree;

public class binaryTreemaximumPathSum {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	private int maxSum = Integer.MIN_VALUE; 
	
	
	public int maxPathSum(TreeNode root) {
		if(root == null) 
			return Integer.MIN_VALUE;
		
		int l = maxPathSum(root.left);
		int r = maxPathSum(root.right);
		
		
		if(Math.max(l, r) > maxSum) 
			maxSum = Math.max(l, r);
		if(l != Integer.MIN_VALUE && r != Integer.MIN_VALUE) {
			maxSum = Math.max(maxSum, l + r + root.val);
		}
		
		maxSum = Math.max(maxSum, root.val);
		
		if(l == Integer.MIN_VALUE || r == Integer.MIN_VALUE) {
			if(l == Integer.MIN_VALUE  && r == Integer.MIN_VALUE) {
				return root.val;
			}
			if(l != Integer.MIN_VALUE ) {
				return root.val + l;
			}else {
				return root.val + r;
			}
		}
		
		return root.val + l + r;
	}
	
	public static void main(String[] args) {
		binaryTreemaximumPathSum maxSum = new binaryTreemaximumPathSum();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
//		root.right = new TreeNode(3);
//		root.right.left = new TreeNode(15);
//		root.right.right = new TreeNode(7);
		
		maxSum.maxPathSum(root);
		System.out.println(maxSum.maxSum);
	}
}
