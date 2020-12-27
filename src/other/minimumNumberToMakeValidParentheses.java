package other;

import java.util.Stack;

public class minimumNumberToMakeValidParentheses {
	public String validParentheses(String s) {
		Stack<Integer> st = new Stack<>();
		StringBuilder sb = new StringBuilder(s);
		
		for(int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i) == '(') 
				st.push(i);
			else if(sb.charAt(i) == ')') {
				if(!st.isEmpty()) {
					st.pop();
				}else {
					sb.setCharAt(i, '*');
				}
			}
		}
		
		while(!st.isEmpty()) {
			sb.setCharAt(st.pop(), '*');
		}
		
		return sb.toString().replace("*", "");
	}

	public static void main(String[] args) {
		minimumNumberToMakeValidParentheses p = new minimumNumberToMakeValidParentheses();
		System.out.println(p.validParentheses("lee(t(c)o)de)"));
	}
}
