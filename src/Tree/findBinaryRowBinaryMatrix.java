package Tree;

import java.util.Arrays;

public class findBinaryRowBinaryMatrix {
	static class TrieNode{
		TrieNode[] children = new TrieNode[2];
		boolean isEndOfWord;
		TrieNode() {
			Arrays.fill(children, null);
			isEndOfWord = false;
		}
	}
	TrieNode root;
	
	public boolean insert(int[] arr) {
		TrieNode curr = this.root;
		for(int i : arr) {
			if(curr.children[i] == null) {
				curr.children[i] = new TrieNode();
			}
			curr = curr.children[i];
		}
		if(curr.isEndOfWord == true) return true;
		curr.isEndOfWord = true;
		return false;
	}
	
	public static void main(String[] args) {
		findBinaryRowBinaryMatrix duplicate = new findBinaryRowBinaryMatrix();
		duplicate.root = new findBinaryRowBinaryMatrix.TrieNode();
		
		int mat[][] =
			{
				{1, 0, 0, 1, 0},
				{0, 1, 1, 0, 0},
				{1, 0, 0, 1, 0},
				{0, 0, 1, 1, 0},
				{0, 1, 1, 0, 0}
			};
		
		for(int row = 0; row < mat.length; row ++) {
			if(duplicate.insert(mat[row])) {
				System.out.println("Row " + (row + 1)+" is duplicate");
			}
		}
		
	}

}
