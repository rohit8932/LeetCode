package DP;

import java.util.Arrays;

public class minCoin {
	
	public int minCoin_topdown(int N, int coins[]) {
		
		if(N == 0) return 0;
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < coins.length; i++) {
			if (coins[i] <= N) {
				int currMin = minCoin_topdown(N - coins[i], coins);
				if (currMin < min)
					min = currMin;
			}
		}
		return min + 1;
	}
	
	
	public int minCoin_DP(int N, int[] coins) {
		int[] ans = new int[N + 1];
		Arrays.fill(ans, Integer.MAX_VALUE);
		ans[0] = 0;
		ans[1] = 1;
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < coins.length; j++) {
				if(coins[j] <= i) {
					int temp = ans[i - coins[j]];
					ans[i] = Math.min(ans[i], temp  +1);
				}
			}
		}
		return ans[N];
	}
	
	public static void main(String[] args) {
		minCoin mc = new minCoin();
		int[] coins = {1, 5, 6, 9};
		System.out.println(mc.minCoin_topdown(10, coins));
		System.out.println(mc.minCoin_DP(10, coins));
	}

}
