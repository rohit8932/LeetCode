package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeIntervals {

	 public int[][] merge(int[][] intervals) {
	       if (intervals.length == 0  || intervals.length == 1) return intervals;
			Arrays.sort(intervals, (num1, num2) -> Integer.compare(num1[0], num2[0]));
			int[] curr_interval = intervals[0];
			List<int[]> output = new ArrayList<>();
			output.add(curr_interval);
			for (int[] interval : intervals) {
				int curr_start = curr_interval[0];
				int curr_end = curr_interval[1];
				int next_begin = interval[0];
				int next_end = interval[1];

				if (curr_end >= next_begin) {
					curr_interval[1] = Math.max(curr_end, next_end);
				} else {
					curr_interval = interval;
					output.add(curr_interval);
				}

			}
			return output.toArray(new int[output.size()][]);
	    }

	public static void main(String[] args) {
		mergeIntervals merge = new mergeIntervals();
//		int[][] output = merge.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
		int[][] output = merge.merge(new int[][] { { 1, 4 }, { 4, 6 } });

		for (int[] interval : output) {
			System.out.println("[" + interval[0] + "," + interval[1] + "]");
		}
	}

}
