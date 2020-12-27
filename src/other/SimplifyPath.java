package other;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
	
	 public String simplifyPath_util(String path) {
		 String[] dir = path.split("/");
		 List<String> skip = Arrays.asList(".", "", "..");
		 Stack<String> st = new Stack<>();
		 String result = "";
		 
		 for(String d : dir) {
			 if(d.equals("..") && !st.isEmpty()) {
				 st.pop();
			 }else if(skip.contains(d) == false) st.push(d);
		 }
		 
		 for(String r : st) { 
			 result = result+ "/"+r;
		 }
		 return result.isEmpty()? "/" : result;
	 }
	 
	 public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath_util(""));
	}

}
