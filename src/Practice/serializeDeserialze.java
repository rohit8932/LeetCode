package Practice;

import java.util.LinkedList;
import java.util.Queue;

public class serializeDeserialze {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	
	
	public String serialize(TreeNode root) {
		String str = "";
		if(root == null) return str;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode temp = q.remove();
			if (temp == null) {
				str += "NULL,";
			} else {
				str += temp.val + ",";
				if (temp.left != null)
					q.add(temp.left);
				else
					q.add(null);
				if (temp.right != null)
					q.add(temp.right);
				else
					q.add(null);
			}

		}
		return str;
	}
	
	
	public TreeNode deserialize(String data) {
		if(data.length() == 0 ) return null;
		String[] str = data.split(",");
		TreeNode root = null;
		if (str[0].equals("NULL") == false) {
			root = new TreeNode(Integer.parseInt(str[0]));
		} else
			return root;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int k = 1;

		while (k < (str.length / 2)*2 + 1 ) {
			TreeNode temp = q.remove();
			if (temp != null) {
				if (str[k].equals("NULL") == false) {
					temp.left = new TreeNode(Integer.parseInt(str[k]));
					k++;
					q.add(temp.left);
				} else {
					temp.left = null;
					k++;
					q.add(temp.left);
				}

				if (str[k].equals("NULL") == false) {
					temp.right = new TreeNode(Integer.parseInt(str[k]));
					k++;
					q.add(temp.right);
				} else {
					temp.right = null;
					k++;
					q.add(temp.right);
				}
			}

		}

		return root;

	}
	
	public static void main(String[] args) {
		serializeDeserialze seDse = new serializeDeserialze();
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		
//		System.out.println(seDse.serialize(root));
		String str = seDse.serialize(null);
		TreeNode newRoot = seDse.deserialize(str);
//		System.out.println();
//		System.out.println(newRoot.val);
//		System.out.println(newRoot.left.val);
//		System.out.println(newRoot.right.val);
	}
	

}
