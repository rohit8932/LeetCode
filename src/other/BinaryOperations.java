package other;

public class BinaryOperations {
	
	public void moveBits() {
		int num = 1;
		for(int i = 1; i <= 32; i++) {
			System.out.print(num + " ");
			num = num << 1;
		}
	}
	
	public boolean test1BitsEachOfGivenInteger(int num) {
		int p = 1, counter = 0;
		if(num == 1 || num == 0) return false;
		for(int i = 1; i < 31; i++) {
			if((p & num)  > 0) {
				counter++;
				if(counter > 1)
					return false;
			}
			p = p << 1;
		}
		return true;
	}
	
	
	
	public static void main(String[] args) {
		BinaryOperations bo = new BinaryOperations();
		bo.moveBits();
//		System.out.println(bo.test1BitsEachOfGivenInteger(1));
	}

}
