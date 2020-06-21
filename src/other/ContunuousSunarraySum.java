package other;

/*Given a list of non-negative numbers and a target integer k, write a function to check 
 * if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, 
 * that is, sums up to n*k where n is also an integer.



Example 1:

Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.

Example 2:

Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
*/

public class ContunuousSunarraySum {

	public boolean checkSubarraySum(int[] nums, int k) {

		for (int i = nums.length - 1; i > 0; i--) {
			int j = i - 1;
			int sum = nums[i];
			while (j >= 0) {
				sum += nums[j];
				if (k == 0) {
					if (sum == 0)
						return true;
				} else if (sum % k == 0)
					return true;

				j--;
			}

		}
		return false;

	}

	public static void main(String[] args) {
		ContunuousSunarraySum css = new ContunuousSunarraySum();
		css.checkSubarraySum(new int[] {1,0,1,0,1}, 4);
	}

}
