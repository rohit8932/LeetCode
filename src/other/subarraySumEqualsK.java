package other;

import java.util.HashMap;
import java.util.Map;

/*Given an array of integers and an integer k, you need to find the total number of continuous subarrays 
  whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2 */

public class subarraySumEqualsK {
	public int findTotalNumContSubArrSum(int[] arr, int k) {
		int sum = 0, ans = 0;
		for(int i = 0; i < arr.length; i++) {
			sum = arr[i];
			if(sum == k) ans ++;
			for(int j = i + 1; j < arr.length; j++) {
				sum += arr[j];
				if(sum == k) ans ++;
			}
		}
		return ans;
	}
	
	public int efficient(int[] arr, int k) {
		return -1;
		
		
	}
	
	
	public static void main(String[] args) {
		subarraySumEqualsK sub = new subarraySumEqualsK();
		System.out.println(sub.findTotalNumContSubArrSum(new int[] {1, 1, 1}, -1));
	}

}
