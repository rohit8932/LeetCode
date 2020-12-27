package other;

public class sudokuValidator {
	
	
	public boolean verifySuduko(char[][] board) {
		for(int r = 0; r < board.length; r ++) {
			for(int c = 0; c < board[0].length; c++) {
				if(isSafeRC(board, r, c) == false) {
					System.out.println("1 " + r 	+  " " + c);
					return false;
				}
				if(isSafeSubBox(board, r, c) == false) {
					System.out.println("2 " + r 	+  " " + c);
					return false;
				}
				
			}
		}
		
		return true;
	}

	
	private boolean isSafeRC(char[][] board, int r, int c) {
		for(int i = 0; i < board.length; i ++) {
			if(board[i][c] != '.' && board[i][c] == board[r][c] && i != r) return false;
		}
		
		for(int i = 0; i < board[0].length; i ++) {
			if(board[r][i] != '.' && board[r][i] == board[r][c] && i != c) return false;
		}
		
		return true;
	}
	
	private boolean isSafeSubBox(char[][] board, int r, int c) {
		int row = -1, col = -1;
		if(r <= 2 ) {
			row = 0;
		}else if(r <= 5) {
			row = 3;
		}else {
			row = 6;
		}
		
		
		if(c <= 2 ) {
			col = 0;
		}else if(c <= 5) {
			col = 3;
		}else {
			col = 6;
		}
		
		for(int i = row; i < row + 3; i ++) {
			for(int j = col; j < col + 3; j ++) {
				if(board[i][j] != '.' && board[i][j] == board[r][c] && i != r && j != c) return false;
			}
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		char[][] board = new char[][]{
			  {'5','3','.','.','7','.','.','.','.'},
			  {'6','.','.','1','9','5','.','.','.'},
			  {'.','9','8','.','.','.','.','6','.'},
			  {'8','.','.','.','6','.','.','.','3'},
			  {'4','.','.','8','.','3','.','.','1'},
			  {'7','.','.','.','2','.','.','.','6'},
			  {'.','6','.','.','.','.','2','8','.'},
			  {'.','.','.','4','1','9','.','.','5'},
			  {'.','.','.','.','8','.','.','7','9'}
			};
		
		sudokuValidator sv = new sudokuValidator();
		System.out.println(sv.verifySuduko(board));
		
			
			
	}
	
	
}
