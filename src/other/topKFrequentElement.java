package other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class topKFrequentElement {
	
	public List<Integer> topKFreqElement(int[] nums, int k) {
		Map<Integer, Integer> freq = new HashMap<>();
		List<LinkedList<Integer>> bucket = new ArrayList<>(nums.length + 1);
		List<Integer> ans = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
			
		}
		
		for(int i = 0; i < nums.length + 1; i++)
			bucket.add(i , new LinkedList<Integer>());
		
		
		for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			bucket.get(entry.getValue()).add(entry.getKey());
			
		}
		
		int trav = bucket.size() - 1;
		while(k > 0 ) {
			if(bucket.get(trav).size() != 0) {
				for(int e : bucket.get(trav)) {
					ans.add(e);
					k --;
					if(k <= 0) return ans;
				}
			}
			trav --;
		}
		
		return ans;
		
	}
	
	
	public List<Integer> topKFrequent(int[] nums, int k) {
	    // build hash map : character and how often it appears
	    HashMap<Integer, Integer> count = new HashMap();
	    for (int n: nums) {
	      count.put(n, count.getOrDefault(n, 0) + 1);
	    }

	    // init heap 'the less frequent element first'
	    PriorityQueue<Integer> heap =
	            new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

	    // keep k top frequent elements in the heap
	    for (int n: count.keySet()) {
	      heap.add(n);
	      if (heap.size() > k)
	        heap.poll();
	    }

	    // build output list
	    List<Integer> top_k = new LinkedList();
	    while (!heap.isEmpty())
	      top_k.add(heap.poll());
	    Collections.reverse(top_k);
	    return top_k;
	  }
	
	public static void main(String[] args) {
		topKFrequentElement top = new topKFrequentElement();
//		List<Integer> ans = top.topKFreqElement(new int[] {1,1,1,2,2,3}, 2 );
//		List<Integer> ans = top.topKFreqElement(new int[] {1},  1);
		
		List<Integer> ans = top.topKFrequent(new int[] {10, 10, 1}, 1 );
		for(int e : ans)
			System.out.print(e + " ");
	}

}
