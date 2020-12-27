package other;

public class MergeSortedArray {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int j = 0, k = 0;
        
        for(int i = 0; i < m + n ; i ++){
            if(j < m && k < n){
                if(nums1[j] < nums2[k]){
                    temp[i] = nums1[j++];
                }else{
                    temp[i] = nums2[k++];
                }
            }else{
                if(j < m){
                    temp[i] = nums1[j++];
                }
                
                if(k < n){
                    temp[i] = nums2[k++];
                }
            }
            
        }
        
        nums1 = temp;
    }
	
	
	public void merge2(int[] nums1, int m, int nums2[], int n) {
		int i = m - 1, j = n - 1, k = m + n - 1;
		
		while(i >= 0 && j >= 0) {
			nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
		}
		
		while(j >= 0) {
			nums1[k--] = nums2[j];
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		MergeSortedArray msa = new MergeSortedArray();
		int[] nums1 = new int[] {1,2,3,0,0,0};
		int [] nums2 = new int[] {2,5,6};
		
		msa.merge(nums1, 3, nums2, 3);
		
		
	}

}
