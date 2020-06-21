package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	
	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int v){
			this.val = v;
			this.left = null;
			this.right = null;
		}
	}
	TreeNode root = null;
	public void add(int n) {
		if(root == null)
			root = new TreeNode(n);
		else {
			Queue<TreeNode> q = new LinkedList<>();
			q.add(root);
			while(!q.isEmpty()) {
				TreeNode temp = q.remove();
				if(temp.left == null) {
					temp.left = new TreeNode(n);
					return;
				}else
					q.add(temp.left);
				if(temp.right == null) {
					temp.right = new TreeNode(n);
					return;
				}else
					q.add(temp.right);
			}
		}
	}
	
	public void iterativeInorder(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		while(root != null || !s.empty()) {
			while(root != null) {
				s.push(root);
				root = root.left;
			}
			
			TreeNode temp = s.pop();
			if(temp != null)
				System.out.print(temp.val + " ");
			root = temp.right;
			
				
		}
		
	}
	
	public void itetativePreorder(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		while(!s.isEmpty()) {
			TreeNode temp = s.pop();
			System.out.print(temp.val + " ");
			if(temp.right != null) {
				s.push(temp.right);
			}
			if(temp.left != null) {
				s.push(temp.left);
			}
		}
	}
	
	public boolean checkBST(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		TreeNode pre = null;
		while(root != null || !s.empty()) {
			while(root != null) {
				s.push(root);
				root = root.left;
			}
			
			TreeNode temp = s.pop();
			if(pre != null && temp.val <= pre.val) return false;
			pre = temp;
			root = temp.right;
		}
		
		return true;
	}
	
	public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return null;
		if(root.val == p.val || root.val == q.val)
			return root;
		
		TreeNode left = lca(root.left, p, q);
		TreeNode right = lca(root.right, p, q);
		if(left != null && right != null) return root;
		if(left != null) return left;
		else
			return right;
				
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.add(50);
		bt.add(30);
		bt.add(70);
		bt.add(10);
		bt.add(40);
		bt.add(60);
		bt.add(100);
		
//		bt.iterativeInorder(bt.root);
//		System.out.println();
//		bt.itetativePreorder(bt.root);
//		System.out.println(bt.checkBST(bt.root));
		
		System.out.println(bt.lca(bt.root, new TreeNode(100), new TreeNode(30)).val);
	}

}
