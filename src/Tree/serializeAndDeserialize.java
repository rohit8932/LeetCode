package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class serializeAndDeserialize {
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        String s = "";
        if(root == null) return s;
        q.add(root);
        while(!q.isEmpty()) {
        	TreeNode temp = q.remove();
        	if(temp != null) {
        		s = s + temp.val+",";
        		
        		if(temp.left != null) {
            		q.add(temp.left);
            	}else {
            		q.add(null);
            	}
            	
            	if(temp.right != null) {
            		q.add(temp.right);
            	}else {
            		q.add(null);
            	}
        	}else {
        		s = s + "NULL,";
        	}
        }
        return s;
        
    }
	
	 public TreeNode deserialize(String data) {
		 if(data.isEmpty() || data == null) return null;
		 String[] nodes = data.split(",");
		 Queue<TreeNode> q = new LinkedList<>();
		 TreeNode root = null;
		 
		 if(!nodes[0].equals("NULL")) {
			 root = new TreeNode(Integer.parseInt(nodes[0]));
			 q.add(root);
		 }else
			 return null;
		 
		 int j = 1;
		 while(!q.isEmpty()) {
			 TreeNode temp = q.remove();
			 if(j < nodes.length) {
				 if(!nodes[j].equals("NULL")) {
					 temp.left = new TreeNode(Integer.parseInt(nodes[j]));
					 j++;
					 q.add(temp.left);
				 }else {
					 temp.left = null;
					 j++;
				 }
			 }
			 
			 if(j < nodes.length) {
				 if(!nodes[j].equals("NULL")) {
					 temp.right = new TreeNode(Integer.parseInt(nodes[j]));
					 j++;
					 q.add(temp.right);
				 }else {
					 temp.right = null;
					 j++;
				 }
			 }
			 
		 }
		 
		 return root;
	 }
	 
	 public void preorder(TreeNode root) {
		 if(root != null) {
			 System.out.print(root.val + " ");
			 preorder(root.left);
			 preorder(root.right);
		 }
	 }
	 
	 public static void main(String[] args) {
		serializeAndDeserialize SD = new serializeAndDeserialize();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
//		System.out.println(SD.serialize(root));
		
		TreeNode newRoot = SD.deserialize(SD.serialize(root));
		
		SD.preorder(newRoot);
		
	}
	

}
