package other;

public class maxConsecutiveOnes_3 {
	
	public int maxContinuousones(int[] A, int k) {
		int begin = 0, end  = 0, ans = Integer.MIN_VALUE;
		
		while(end < A.length) {
			if(A[end] == 1) {
				end ++;
			}else if(A[end] == 0 && k > 0) {
				end ++;
				k --;
			}else {
				while(k <= 0  && begin < A.length) {
					if(A[begin] == 0) k++;
					begin ++;
				}
			}
			ans = Math.max(ans, end - begin); //why not in else condition? well what if k > A.length, it will never to come to else condition
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		maxConsecutiveOnes_3 mco = new maxConsecutiveOnes_3();
		int[] A = new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int k = 3;
		System.out.println(mco.maxContinuousones(A, k));
	}

}
