package other;

public class slidingWindow_MaximumOfAllSubarrayofSizeK {
	
	public int  maxHeap(int[] arr, int k, int l, int h) {
		if(k >= arr.length) return Integer.MAX_VALUE;
		int[] heap = new int[k + 1];
		int index = 0;
		for(int i = l; i <= h; i++) {
			heap[++index] = arr[i];
		}
		for(int i = k / 2; i >= 1; i--) {
			heapify(heap, i, k);
		}
		return heap[1];
	}
	
	private void heapify(int[] heap, int i, int k) {
		int largest = i;
		int left = largest * 2;
		int right = largest * 2 + 1;
		
		if(left <= k && heap[left] > heap[largest])
			largest = left;
		if(right <= k && heap[right] > heap[largest])
			largest = right;
		if(largest != i) {
			int temp = heap[i];
			heap[i] = heap[largest];
			heap[largest] = temp;
			
			heapify(heap, largest, k);
		}
		
		
	}
	
	public static void main(String[] args) {
		slidingWindow_MaximumOfAllSubarrayofSizeK maxHeap = new slidingWindow_MaximumOfAllSubarrayofSizeK();
		int[] arr = new int[] {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		int k = 4;
		int low = 0, high = k - 1;
		while(high < arr.length) {
			System.out.print(maxHeap.maxHeap(arr, k, low, high) + " ");
			low++;
			high ++;
		}
		
	}

}
