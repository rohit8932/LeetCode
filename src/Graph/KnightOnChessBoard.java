package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class KnightOnChessBoard {
	static class Cell{
		int x, y;
		Cell(int i, int j){
			this.x = i;
			this.y = j;
		}
	}
	public int knight(int A, int B, int C, int D, int E, int F) {
		C = C-1; //below 4 lines done just for index related things
		D = D-1;
		E = E - 1; //target x coordinate
		F = F - 1; //target y coordinate
		Queue<Cell> q = new LinkedList<>();
		boolean[][] visited = new boolean[A][B];
		q.add(new Cell(C, D));
		visited[C][D] = true;
		int ans = 0;
		int[] row = {-2, -2, 1, 1, -1, -1, 2, 2};
		int[] col = {1, -1, 2, -2, -2, 2, -1, 1};
		while(q.isEmpty() == false) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				Cell temp = q.poll();
				if(temp.x == E && temp.y == F) return ans; //we reached the target
				for(int c = 0; c < row.length; c++) {
					int newX = temp.x + row[c];
					int newY = temp.y + col[c];
					if(newX > -1 && newX < A && newY > -1 && newY < B && visited[newX][newY] == false) {
						q.add(new Cell(newX, newY));
						visited[newX][ newY] = true;
					}
				}
			}
			ans++;
		}
		return -1;
		
    }
	
	
	
	public int knight_2(int A, int B, int C, int D, int E, int F) {
		Queue<Cell> q = new LinkedList<>();
		boolean[][] visited = new boolean[A + 1][B + 1];
		q.add(new Cell(C, D));
		visited[C][D] = true;
		int ans = 0;
		int[] row = {-2, -2, 1, 1, -1, -1, 2, 2};
		int[] col = {1, -1, 2, -2, -2, 2, -1, 1};
		while(q.isEmpty() == false) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				Cell temp = q.poll();
				if(temp.x == E && temp.y == F) return ans;
				for(int c = 0; c < row.length; c++) {
					int newX = temp.x + row[c];
					int newY = temp.y + col[c];
					if(newX > 0 && newX <= A && newY > 0 && newY <= B && visited[newX][newY] == false) {
						q.add(new Cell(newX, newY));
						visited[newX][ newY] = true;
					}
				}
			}
			ans++;
		}
		return -1;
		
    }
	
	public static void main(String[] args) {
		KnightOnChessBoard kocb = new KnightOnChessBoard();
//		System.out.println(kocb.knight_2(8, 8, 1, 1, 8, 8));
		System.out.println(kocb.knight_2(2, 20, 1, 18, 1, 5));
	}

}
