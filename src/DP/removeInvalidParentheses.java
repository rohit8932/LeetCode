package DP;

import java.util.HashSet;
import java.util.Stack;

public class removeInvalidParentheses {
	
	public int invalidParenthesis(String str) {
		Stack<Character> st = new Stack<>();
		for(char c : str.toCharArray()) {
			if(c == '(') st.push(c);
			else if(st.size() > 0 && st.peek() == '(' && c == ')') st.pop();
			else if(c == ')') st.push(c);
		}
		return st.size();
	}
	
	
	void solution(String str, int min, HashSet<String> result){
		if(min == 0) {
			if(invalidParenthesis(str) == 0)
				 if(result.contains(str) == false) {
					 System.out.println(str);
					 result.add(str);
				 }
					 	
			return;
		}
		
		for(int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 40 || str.charAt(i) == 41) {
				String left = str.substring(0, i);
				String right = str.substring(i + 1);
				solution(left + right, min - 1, result);
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		removeInvalidParentheses rip = new removeInvalidParentheses();
//		System.out.println(rip.invalidParenthesis("()())()"));
		String str = ")(";
		
		rip.solution(str, rip.invalidParenthesis(str),
				new HashSet<String>());
		
	}

}
