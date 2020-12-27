package other;

import java.util.HashMap;

public class subArraySumEqualsK {
	
	
	public int numOfSubArray(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int count = 0;
		int sum = 0;
		for(int i = 0; i < arr.length; i ++) {
			sum += arr[i];
			if(map.containsKey(sum - k)) { //if sum(i) - sum(j) = k then sum(i) - k = sum(j), j<=i
				count += map.get(sum - k);
			}
			
			map.put(sum, map.getOrDefault(sum, 0) + 1);
			
			
		}
		
		return count;
	}

	public static void main(String[] args) {
		subArraySumEqualsK sasek = new subArraySumEqualsK();
		System.out.println(sasek.numOfSubArray(new int[] {1, 2, -3, 1, 2, -3, 1, 2}, 3));
	}
}
