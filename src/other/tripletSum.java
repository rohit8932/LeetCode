package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tripletSum {
	
	//time- O(n^3) space- O(n)
	public void bruteForce(int[] arr) {
		int n = arr.length;
		List<List<Integer>> output = new ArrayList<>();
		
		
		for(int i = 0; i < n - 2; i++ ) {
			for(int j = i + 1; j < n - 1; j++ ) {
				for(int k = j + 1; k < n; k++ ) {
					if(arr[i] + arr[j] + arr[k] == 0 ) { 
							output.add(Arrays.asList(arr[i], arr[j], arr[k]));
							j++;
						}
					
					
				}
			}
		}
		
		for(List<Integer> e : output) {
			System.out.println(e.get(0) + " " + e.get(1) + " " + e.get(2) );
		}
	}
	
	public void betterSol(int[] arr) {
		List<List<Integer>> output = new ArrayList<>();
		Arrays.sort(arr);
		int n = arr.length;
		for (int i = 0; i < n - 2; i++) {
			if (i == 0 || (arr[i] != arr[i - 1])) {
				int x = arr[i];
				int left = i + 1;
				int right = n - 1;
				while (left < right) {
					if (x + arr[left] + arr[right] == 0) {
						output.add(Arrays.asList(x, arr[left], arr[right]));
						while (left < right && arr[left] == arr[left + 1])
							left++;
						while (left < right && arr[right] == arr[right - 1])
							right--;
						left++;
						right--;
					} else if (x + arr[left] + arr[right] < 0) {
						left++;
					} else
						right--;
				}
			}
			
		}
		for (List<Integer> e : output) {
			System.out.println(e.get(0) + " " + e.get(1) + " " + e.get(2));
		}

	}
	

	public static void main(String[] args) {
		tripletSum ts = new tripletSum();
		int[] arr = new int[] {-1, 0, 1, 2, -1, -4};
//		int[] arr = new int[] {-4, -1, -1, 0, 1, 2};
		
		
//		ts.bruteForce(arr);
		ts.betterSol(arr);
	}
}
