package other;

public class sumOfTwoNumberUsingBinary {
	
	public int sum(int p, int q) {
		while(q != 0) {
			int carry = (p & q);
			p = (p ^ q);
			q = (carry << 1);
		}
		return p;
		
	}
	
	public static void main(String[] args) {
		sumOfTwoNumberUsingBinary sum = new sumOfTwoNumberUsingBinary();
		System.out.println(sum.sum(100, -120));
	}

}
