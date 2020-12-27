package other;

/*Given an integer array nums, find the contiguous subarray (containing at least one number) 
 which has the largest sum and return its sum.

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and c
onquer approach, which is more subtle.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.*/

public class MaximumSubArray_Kadane {

	public int findMaxSubArray(int[] arr) {
		int max_sofar = Integer.MIN_VALUE;
		int max_here = 0;
		
		for(int i = 0; i < arr.length; i++) {
			max_here = max_here + arr[i];
			max_here = Math.max(arr[i], max_here); //if u r more negative, try to minimize it or get rid of
			
			max_sofar = Math.max(max_sofar, max_here); //once max recorded, will not change until next max comes
		}
		
		return max_sofar;
	}
	
	
	public static void main(String[] args) {
		MaximumSubArray_Kadane ka = new MaximumSubArray_Kadane();
		System.out.println(ka.findMaxSubArray(new int[] {1}));
	}
	
}
