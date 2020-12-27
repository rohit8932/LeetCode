package other;

public class searchInRotatedArray {

	public int search(int[] nums, int target) {
		if (nums.length == 0)
			return -1;
		int divide = findDeflex(nums, 0, nums.length - 1);
		int res;
		res = binarySearch(nums, 0, divide - 1, target);
		if (res == -1)
			res = binarySearch(nums, divide, nums.length - 1, target);

		return res;

	}

	public int findDeflex(int[] nums, int s, int e) {

		while (s < e) {
			int mid = (e - s) / 2 + s;
			if (nums[mid] > nums[e]) {
				s = mid + 1;
			} else {
				e = mid; //why not mid - 1?
			} 

		}
		return s;
	}

	int binarySearch(int[] nums, int l, int h, int target) {

		while (l <= h) {
			int mid = (h - l) / 2 + l;
			if (nums[mid] < target) {
				l = mid + 1;
			} else if (nums[mid] > target) {
				h = mid - 1;
			} else {
				return mid;
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		searchInRotatedArray sira = new searchInRotatedArray();
		System.out.println(sira.search(new int[] {2,2,2,0,2,2}, 0));
		System.out.println(sira.findDeflex(new int[] {2,2,2,0,2,2}, 0, 5));
	}

}
