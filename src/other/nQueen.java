package other;

public class nQueen {
	
	
	public boolean placeQueen(int[][] board, int r) {
		if(r == board.length) return true;
		
		for(int col = 0; col < board[0].length; col ++) {
			if(isSafe(board, r, col)) {
				board[r][col] = 1;
				if(placeQueen(board, r + 1) ) return true;
				board[r][col] = 0;
			}
		}
		
		
		return false;
		
	}

	private boolean isSafe(int[][] board, int r, int c) {
		for(int i = r - 1; i >=0 ; i --) {
			if(board[i][c] == 1) return false;
			
		}
		
		for(int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
			if(board[i][j] == 1) return false;
		}
		
		for(int i = r - 1, j = c + 1; i >= 0 && j < board[0].length; i --, j ++) {
			if(board[i][j] == 1) return false;
		}
		
		return true;
		
	}
	
	
	public static void main(String[] args) {
		nQueen queen = new nQueen();
		int[][] board = new int[8][8];
		queen.placeQueen(board, 0);
		
		
		for(int i = 0; i < board.length; i ++) {
			for(int j = 0; j < board[0].length; j ++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
