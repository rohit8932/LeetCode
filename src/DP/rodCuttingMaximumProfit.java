package DP;

public class rodCuttingMaximumProfit {
	
	public int rodCutting_topDown(int[] prices, int n) {
		if(n <= 0) return 0;
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < prices.length; i++) {
			if(n >= i) {
				max = Math.max(max, prices[i] + rodCutting_topDown(prices, n - i));
			}
		}
		return max;
	} 
	
	public int rodCuting_bottomUp(int[] prices, int n) {
		int[] res = new int[n + 1];
		res[0] = 0;
		
		for(int i = 1; i <= n; i++) {
			int max = Integer.MIN_VALUE;
			for(int j = 0; j <= Math.min(prices.length-1, i); j++) {
				max = Math.max(max, prices[j] + res[i - j]);
			}
			res[i] = max;
		}
		
		return res[n];
		
	}
	
	
	
	public static void main(String[] args) {
		rodCuttingMaximumProfit rc = new rodCuttingMaximumProfit();
//		long start = System.nanoTime();
		System.out.println(rc.rodCutting_topDown(new int[] {0, 1, 5, 8, 9, 10, 17, 20}, 20));
//		long stop = System.nanoTime();
//		System.out.println("Recurisive took " + (stop - start));
		
//		start = System.nanoTime();
		System.out.println(rc.rodCuting_bottomUp(new int[] {0, 1, 5, 8, 9, 10, 17, 2}, 2));
//		stop = System.nanoTime();
//		System.out.println("DP took " + (stop - start));
		
	}

}
