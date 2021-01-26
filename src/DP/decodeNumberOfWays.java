package DP;

public class decodeNumberOfWays {
	public int numOfWays(String s, int index) {
		if(index == s.length()) 
			return 1;
		
		if(index == s.length() - 1) 
			return 1;
		int ways1 = numOfWays(s, index + 1);
		int ways2 = 0;
		if(Integer.parseInt(s.substring(index, index + 2)) < 27) {
			ways2 = numOfWays(s, index + 2);
		}
		
		return ways1 + ways2;
	}

	
	public static void main(String[] args) {
		decodeNumberOfWays dnw = new decodeNumberOfWays();
		System.out.println(dnw.numOfWays("128", 0));
	}
}
