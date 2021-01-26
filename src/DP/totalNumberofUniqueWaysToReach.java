package DP;

public class totalNumberofUniqueWaysToReach {
	
	int numWays(int N, int score) {
		if(score < 0) return 0;
		if(score == 0) return 1;
		
		return numWays(N, score - 3) + numWays(N, score - 5) + numWays(N, score - 10);
	}
	
	
	int numWays_DP(int N) {
		int[] ans = new int[N + 1];
		ans[0] = 1;
		
		for(int i = 1; i <= N; i++) {
			if(i - 3 >= 0) {
				ans[i] += ans[i - 3];
			}
			if(i - 5 >= 0) {
				ans[i] += ans[i - 5];
			}
			if(i - 10 >= 0) {
				ans[i] += ans[i - 10];
			}
		}
		
		return ans[N];
		
	}
	
	
	public static void main(String[] args) {
		totalNumberofUniqueWaysToReach tnouwtr = new totalNumberofUniqueWaysToReach();
		System.out.println(tnouwtr.numWays(13, 13));
		
		System.out.println(tnouwtr.numWays_DP(13));
	}
}
