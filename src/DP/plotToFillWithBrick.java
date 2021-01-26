package DP;

public class plotToFillWithBrick {
	/*Given an empty plot of size 2*n, fill the entire plot with tiles of size 2*1, find numOfWays to fill pot fully*/
	
	public int numWays(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(n == 2) return 2;
		
		return numWays(n - 1) + numWays(n - 2);
		
	}
	

	
	public static void main(String[] args) {
		plotToFillWithBrick ptfwb = new plotToFillWithBrick();
		System.out.println(ptfwb.numWays(3));
	}
}
