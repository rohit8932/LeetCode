package Graph;

public class wordSearch {
	
	public boolean isWordPresent(char[][] mat, String word) {
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] == word.charAt(0)) {
					boolean ans = dfs(mat, i, j, 0, word);
					if(ans == true) return true;
							
				}
			}
		}
		return false;
	}
	
	private boolean dfs(char[][] mat, int i, int j, int count, String word) {
		if(count == word.length()) return true;
		if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] != word.charAt(count)) return false;
		
		char temp = mat[i][j];
		mat[i][j] = '*';
		boolean found = dfs(mat, i + 1, j, count + 1, word) || 
				dfs(mat, i - 1, j, count + 1, word) || 
				dfs(mat, i, j + 1, count + 1, word) ||
				dfs(mat, i, j - 1, count + 1, word);
		mat[i][j] = temp;
		return found;
	}
	
	public static void main(String[] args) {
		wordSearch ws = new wordSearch();
		char[][] mat = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(ws.isWordPresent(mat, "ABCCED"));
	}

}
