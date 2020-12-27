package other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class moveZeroes {
	
	public void move(int[] nums){
		 List<Integer> out = new ArrayList<>();
			for(int e : nums) out.add(e);
			Iterator<Integer> it = out.iterator();
			int count = 0;
			while(it.hasNext()) {
				if(it.next() == 0) {
					it.remove();
					count ++;
				}
				
			}
			while(count != 0) {
				out.add(0);
				count --;
			}
			
			Integer[] ans = out.toArray(new Integer[0]);
			for(int i = 0; i < ans.length; i++) {
				nums[i] = ans[i];
			}
	}
	
	
	public void move2(int[] nums) {
		int a = 0;
		int b = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) {
				a++;
			}else {
				nums[b++] = nums[i];
			}
			
		}
		
		while(a != 0) {
			nums[b++] = 0;
			a--;
		}
		
	}
	
	
	public static void main(String[] args) {
		moveZeroes mz = new moveZeroes();
		mz.move(new int[] {0,1,0,3,12});
		
	}
}
