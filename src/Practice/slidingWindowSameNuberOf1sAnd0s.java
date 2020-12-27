package Practice;

import java.util.HashMap;
import java.util.Map;

public class slidingWindowSameNuberOf1sAnd0s {
	
	public int slidindWindow(int numZ, int numO, int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, numZ);
		map.put(1, numO);
		int counter = map.size();
		int ans = 0;
		
		int end = 0, begin = 0;
		while(end < arr.length) {
			if(arr[end] == 0 || arr[end] == 1) {
				map.put(arr[end], map.get(arr[end]) - 1);
				if(map.get(arr[end]) == 0 ) 
					counter --;
			}
			while(counter == 0) {
				if(end - begin + 1 == numZ + numO) {
					ans ++;
				}
				if(arr[begin] == 0 || arr[begin] == 1) {
					map.put(arr[begin], map.get(arr[begin]) + 1);
					if(map.get(arr[begin]) > 0) counter ++;
				}
				begin ++;
			}
			end ++;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		slidingWindowSameNuberOf1sAnd0s sw = new slidingWindowSameNuberOf1sAnd0s();
		int[] arr = new int[] {0, 0, 1, 0, 1, 1, 1};
		System.out.println(sw.slidindWindow(1, 1, arr));
	}
	

}
