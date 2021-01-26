package DP;

public class knapsackProblem {
	
	//time- O(2^n) n is total item, space- O(n) n is total item in bag
	public int knapSack(int[] w, int[] v, int W, int i) {
		if(i == w.length || W - w[i] < 0) //if adding something will make w < 0 just dont add it, 
			return 0;//because after adding item if u reliaze the weight had become <0 then u might also want to revert the values added because of that item which is difficult to do programmatically
		
		return Math.max(knapSack(w, v, W - w[i], i + 1) + v[i], knapSack(w, v, W, i + 1));
	}
	
	public int knapsack_DP(int[] wt, int[] val, int W) {
		int[][] mem = new int[wt.length][W + 1];
		for(int i = 0; i < W + 1; i++) { //in first row you only have option of first item
			if(i >= wt[0])
				mem[0][i] = val[0];
		}
		for(int i = 0; i < wt.length; i++) { //for column 0, we cannot add item when bag capacity is zero
			mem[i][0] = 0;
		}
		
		for(int item = 1; item < wt.length; item++) {
			for(int w = 1; w <= W; w++) {
				if(wt[item] <= w) {
					mem[item][w] = Math.max(val[item] + mem[item - 1][w - wt[item]], mem[item - 1][w]);
				}else {
					mem[item][w] = mem[item - 1][w];
				}
			}
		}
		
		//below code for which item picked
		int res = mem[wt.length - 1][W];
		int res_w = W;
		
		for(int i = wt.length - 1; i >= 0 && res > 0; i --) {
			if(i - 1 == -1) System.out.println("Item " + (i) + " with value " + val[i] + " is included");
			else if(res == mem[i - 1][res_w]) {
				continue;
			}
			else {
				System.out.println("Item " + i + " with value " + val[i] + " is included");
				res = res - val[i];
				res_w = res_w - wt[i];
			}
		}
		
		return mem[wt.length - 1][W];
		
	}
	
	
	public static void main(String[] args) {
		knapsackProblem knap = new knapsackProblem();
		int val[] = new int[] { 60, 100, 120 }; 
        int wt[] = new int[] { 10, 20, 30 }; 
        int W = 10; 
		System.out.println(knap.knapSack(wt, val, W, 0));
		System.out.println(knap.knapsack_DP(wt, val, W));
	}

}
