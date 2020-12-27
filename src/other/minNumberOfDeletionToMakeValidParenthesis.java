package other;

import java.util.HashMap;
import java.util.Stack;

public class minNumberOfDeletionToMakeValidParenthesis {
	
	public int minNumber(String str) {
		Stack<Character> st = new Stack<Character>();
		for(int i = 0; i < str.length(); i ++) {
			if(str.charAt(i) =='(') st.push(str.charAt(i));
			else if(str.charAt(i) == ')'){
				if(st.size() > 0 && st.peek() == '(') st.pop();
				else{
					st.push(str.charAt(i));
				}
			}
		}
		
		return st.size();
	}
	
	public void solution(String str, int min, HashMap<String, Integer> hashMap) {
		if(min == 0) {
			if(isValid(str)) {
				if(hashMap.containsKey(str) == false) {
					System.out.println(str);
					hashMap.put(str, 1);
				}

			}
			return;
		}
		
		for(int i = 0; i < str.length(); i ++) {
			String left = str.substring(0, i);
			String right = str.substring(i + 1);
			
			solution(left + right, min - 1, hashMap);
			
		}
		
	}
	
	public boolean isValid(String str) {
		Stack<Character> st = new Stack<Character>();
		for(int i = 0; i < str.length(); i ++) {
			if(str.charAt(i) == '(') {
				st.push(str.charAt(i));
			}else if(str.charAt(i) == ')'){
				if(st.size() > 0 && st.peek() == '(') {
					st.pop();
				}else{
					st.push(str.charAt(i));
				}
			}
		}
		return st.size() == 0;
	}
	
	public static void main(String[] args) {
		minNumberOfDeletionToMakeValidParenthesis mnodtmvp = new minNumberOfDeletionToMakeValidParenthesis();
		String str = "a";
		int min = mnodtmvp.minNumber(str);
		mnodtmvp.solution(str, min, new HashMap<>());
		
	}
	

}
