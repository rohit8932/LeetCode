package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {
	public int snakesAndLadders(int[][] board) {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		boolean[][] visited = new boolean[board.length][board[0].length];
		int N = board.length;
		visited[N - 1][0] = true;
		int ans = 0;
		
		while(q.isEmpty() == false) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int temp = q.poll();
				if(temp == N*N) return ans; // we reached top most left grid, which is the target
				for(int j = 1; j <= 6; j++) {
					if(temp + j > N*N) break;
					int[] pos = getCoordinate(temp + j, N);
					int x = pos[0];
					int y = pos[1];
					if(visited[x][y] == false) {
						if(board[x][y] == -1)
							q.add(temp + j);
						else
							q.add(board[x][y]);
						visited[x][y] = true;
					}
				}
			}
			ans ++;
		}
		return -1;
	}
	
	private int[] getCoordinate(int val, int N) {
		int[] pos = new int[2];
		int r = (N - (val - 1)/N) - 1; 
		int c = (val -1) % N; //val - 1 is necessary in row and col, since our matrix is one index smaller in both r and c
		
		if(r % 2 == N % 2) {
			pos[0] = r;
			pos[1] = N - c - 1;
			return pos;
		}else {
			pos[0] = r;
			pos[1] = c;
			return pos;
		}
	}
	
	public static void main(String[] args) {
		SnakeAndLadder sal = new SnakeAndLadder();
		int[][] board = {
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,35,-1,-1,13,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,15,-1,-1,-1,-1}};
		System.out.println(sal.snakesAndLadders(board));
	}

}
