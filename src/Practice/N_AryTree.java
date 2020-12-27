package Practice;

import Practice.N_AryTree.TreeNode;

public class N_AryTree {
	static class TreeNode{
		int val;
		TreeNode child;
		TreeNode nextSibling;
		
		TreeNode(int v){
			this.val = v;
			this.child = null;
			this.nextSibling = null;
		}
	}
	
	
	public int sumOfAllElement(TreeNode root) {
		if(root == null) return 0;
		return root.val + sumOfAllElement(root.child) + sumOfAllElement(root.nextSibling);
	}
	
	
	public void preorder(TreeNode root) {
		if(root != null) {
			System.out.print(root.val +  " ");
			preorder(root.child);
			preorder(root.nextSibling);
		}
	}
	
	public static void main(String[] args) {
		N_AryTree ntree = new N_AryTree();	
		TreeNode root = new TreeNode(1);									//    			1
		root.child = new TreeNode(2);									   	//   		   /
		root.child.nextSibling = new TreeNode(3);						  	//  		 2 -- 3 -- 4 -- 7
		root.child.nextSibling.nextSibling = new TreeNode(4);			  	//					   /
		root.child.nextSibling.nextSibling.nextSibling = new TreeNode(7);
		root.child.nextSibling.nextSibling.child = new TreeNode(5);    		//				      5 -- 6	
		root.child.nextSibling.nextSibling.child.nextSibling = new TreeNode(6); //
		
		
//		System.out.println(ntree.sumOfAllElement(root));
		ntree.preorder(root);
		
	}
	

}
