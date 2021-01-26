package DP;

import java.util.Arrays;

public class minStepToReachOne {
	
	public int minStep(int n, int[] memo) {
		if(n == 1) return 0;
		
		if(memo[n] != -1) 
			return memo[n];
		
		int min = minStep(n - 1, memo);
		
		if(n % 2 == 0) {
			min = Math.min(min, minStep(n/2, memo));
		}
		if(n % 3 == 0) {
			min = Math.min(min, minStep(n/3, memo));
		}
		
		memo[n] = min + 1;
		return memo[n];
	}
	public int minStepDP(int n) {
		int[] ans = new int[n + 1];
		ans[0] = 0;
		ans[1] = 0;
		ans[2] = 1;
		ans[3] = 1;
		
		for(int i = 4; i <= n; i++) {
			int temp = ans[i - 1] + 1;
			if (i % 3 == 0) {
				temp = Math.min(temp, ans[i / 3] + 1);

			}if (i % 2 == 0) {
				temp = Math.min(temp, ans[i / 2] + 1);
			}				
			ans[i] = temp;
		}
		
		return ans[n];
	}
	
	
	public static void main(String[] args) {
		minStepToReachOne mstr = new minStepToReachOne();
		int n = 10;
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);
		System.out.println(mstr.minStep(n, memo));
		System.out.println(mstr.minStepDP(n));
	}

}
