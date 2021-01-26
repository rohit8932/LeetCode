package DP;

public class kadane_Dp {
	
	public int kadane_dp(int[] arr) {
		int[] ans = new int[arr.length];
		ans[0] = arr[0];
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < arr.length; i++) {
			ans[i] = Math.max(ans[i-1] + ans[i] , arr[i]);
			if(ans[i] > max) max = ans[i];
		}
		return max;
	}

	public static void main(String[] args) {
		kadane_Dp  kd = new kadane_Dp();
		int[] arr =  {-2, -3, 4, 3, 1, 2, 7, 4};
		System.out.println(kd.kadane_dp(arr));
	}
}
