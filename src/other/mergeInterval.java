package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeInterval {
	
	public int[][] merge(int[][] arr) {
		Arrays.sort(arr, (num1, num2) -> Integer.compare(num1[0], num2[0]));
		List<int[]> output = new ArrayList<>();
		int[] curr = arr[0];
		output.add(curr);
		for(int[] interval : arr) {
			if(curr[1] >= interval[0]) {
				curr[0] = Math.min(curr[0], interval[0]);
				curr[1] = Math.max(curr[1], interval[1]);
			}else {
				curr = interval;
				output.add(curr);
				
			}
		}
		return output.toArray(new int[output.size()][]);
	}
	
	public static void main(String[] args) {
		mergeInterval merge = new mergeInterval();
		int[][] arr = new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
		int[][] output = merge.merge(arr);
		
		for(int[] ans : output) {
			System.out.println(ans[0] + " " + ans[1]);
		}
	}

}
