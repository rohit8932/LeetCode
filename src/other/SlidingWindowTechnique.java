package other;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SlidingWindowTechnique {
	//fixed length window
	//find max sum subarray of length k
	
	public static int maxSumSubarray(int[] arr, int k) {
		int currRunningSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for(int i  = 0; i < arr.length; i++) {
			currRunningSum += arr[i];
			
			if(i >= k - 1) {
				maxSum = Math.max(maxSum, currRunningSum);
				currRunningSum -= arr[i - (k-1)];
				
			}
		}
		
		return maxSum;
	}
	
	//dynamic winodow
	//smallest window with sum equal or greater than given number
	
	public static int  smallestSubarray(int[] arr, int num) {
		int windowStart = 0, windowEnd = 0;
		int currSum = 0;
		int minWindow = Integer.MAX_VALUE;
		for(windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			currSum += arr[windowEnd];
			
			while(currSum >= num) {
				minWindow = Math.min(minWindow, windowEnd - windowStart + 1);
				currSum -= arr[windowStart];
				windowStart += 1;
			}
			
		}
		return minWindow;
	}
	
	//dynamic window with auxilary space
	//longest substring length with k distinct character
	
	public static int longestSubstringWithKDistinct(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int maxLen = Integer.MIN_VALUE;
		int windowStart = 0, windowEnd = 0;
		for(windowEnd = 0; windowEnd < arr.length; windowEnd ++) {
			map.put(arr[windowEnd], map.getOrDefault(arr[windowEnd], 0) + 1);
			
			while(map.size() > k) {
				map.put(arr[windowStart], map.get(arr[windowStart]) - 1) ;
				if(map.get(arr[windowStart]) == 0)
					map.remove(arr[windowStart]);
				
				windowStart += 1;
				
			}
			maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
		}
		return maxLen;
	}
	
	public static String mininumSubstring(String str1, String str2) {
		int windowStart = 0, windowEnd = 0;
		String ans = "";
		int minLen = Integer.MAX_VALUE;
		Map<Character, Integer> map = new HashMap<>();
		for(windowEnd = 0; windowEnd < str1.length(); windowEnd ++) {
			map.put(str1.charAt(windowEnd), map.getOrDefault(str1.charAt(windowEnd), 0) + 1);
			
			while(check(map, str2)) {
				if (windowEnd - windowStart + 1 < minLen) {
					ans = "";
					for (int i = windowStart; i <= windowEnd; i++) {
						ans += str1.charAt(i);
					}
					minLen = windowEnd -windowStart + 1;
				}
//				if(str1.substring(windowStart, windowEnd + 1).length() < minLen) {
//					ans = str1.substring(windowStart, windowEnd + 1);
//					minLen = ans.length();
//				}
					
				map.put(str1.charAt(windowStart), map.get(str1.charAt(windowStart)) -1);
				if(map.get(str1.charAt(windowStart)) == 0)
					map.remove(str1.charAt(windowStart));
				windowStart ++;
			}
				
			}
		return ans;	
	}
	
	
	
	private static boolean check(Map<Character, Integer> map, String str) {
		Map<Character, Integer> temp = new HashMap<Character, Integer>(map);
		for(char c : str.toCharArray()) {
			if(temp.containsKey(c)) {
				temp.put(c, temp.get(c) - 1);
				if(temp.get(c) == 0)
					temp.remove(c);
			}else
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
//		System.out.println(maxSumSubarray(new int[] {4, 2, 2, 7, 8, 1, 2, 8, 10}, 3));
//		System.out.println(smallestSubarray(new int[] {4, 2, 2, 7, 8, 1, 2, 8, 10}, 8));
//		System.out.println(longestSubstringWithKDistinct(new int[] { 1, 1, 1, 5, 5, 7, 2 ,3}, 2));
		
	
		System.out.println(mininumSubstring("cabwefgewcwaefgcf", "cae"));
	}

}
