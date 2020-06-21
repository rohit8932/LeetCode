package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
	
	public void wordBreak(String s, List<String> wordDict) {
        HashMap<String, Integer> dict = new HashMap<>();
        for(String str : wordDict){
            dict.put(str, 0);
        }
        String temp = "";
        wordBreak(s, temp, -1, dict);
        
        for(Integer i : dict.values())
        	System.out.println(i + " ");
        }
        
    
    
    private void wordBreak(String s, String temp, int i, HashMap<String, Integer> dict){
        if(dict.containsKey(temp)){
            dict.put(temp, dict.get(temp)+1);
//            return;
        }
        
        if(i == s.length()-1) return;
        
        wordBreak(s, temp + s.charAt(i+1), i + 1, dict);
        wordBreak(s, temp, i + 1, dict);
        
        
    }
    
    public boolean wordBreakRecur(String word, List<String> dict) {
    	HashSet<String> set = new HashSet<>();
    	HashMap<String, Boolean> memo = new HashMap<>();
    	for(String str : dict) set.add(str);
    	return wordBreakRecur(word, set, memo);
    	
    }
    private boolean wordBreakRecur(String word, HashSet<String> set, HashMap<String, Boolean> memo) {
    	if(word.equals("")) return true;
    	if(memo.get(word) != null) return memo.get(word);
    	for(int i = 0; i <= word.length(); i++) {
    		if(set.contains(word.substring(0, i))){
    			 memo.put(word, wordBreakRecur(word.substring(i, word.length()), set, memo));
    			 if(memo.get(word) == true) return true; 
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args) {
		WordBreak wb = new WordBreak();
//		wb.wordBreak("leetcode", Arrays.asList("leet", "code"));
		System.out.println(wb.wordBreakRecur("leetcode", Arrays.asList("leet", "code")));
	}

}
