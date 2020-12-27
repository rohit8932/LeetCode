package DP;

public class knapsackProblem {
	
	//time- O(2^n) n is total item, space- O(n) n is total item in bag
	public int knapSack(int[] w, int[] v, int W, int i) {
		if(i == w.length || W - w[i] < 0) //if adding something will make w < 0 just dont add it, 
			return 0;//because after adding item if u reliaze the weight had become <0 then u might also want to revert the values added because of that item which is difficult to do programmatically
		
		return Math.max(knapSack(w, v, W - w[i], i + 1) + v[i], knapSack(w, v, W, i + 1));
	}
	
	public static void main(String[] args) {
		knapsackProblem knap = new knapsackProblem();
		int val[] = new int[] { 60, 100, 120 }; 
        int wt[] = new int[] { 10, 20, 30 }; 
        int W = 50; 
		System.out.println(knap.knapSack(wt, val, W, 0));
	}

}
