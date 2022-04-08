package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class GroupAnagrams {
	
	
	//THIS CODE WILL GIVE TLE BUT THIS CODE RUNS FINE 
	//ANOTHER APPROACH IS SORT EVERY STRING AND PUSH THAT TO HASHMAP AND RETURN THE HASHMAP OF< STRING, ArrayLIST<STRING> >
	
	
	public static void groupAnagrams(String[] anagrams) {
		
		List<List<String>>resuList = new ArrayList<List<String>>();
		HashMap<Character, Integer> checkHashMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> checkHashMap1 = new HashMap<Character, Integer>();
		for(int i=0; i<anagrams.length; i++) {
			String s1 = anagrams[i]; 
			if(s1.compareTo("A") == 0)continue;
			checkHashMap.clear();
			boolean flag = false;
			List<String>anagramList = new ArrayList<String>();
			anagramList.add(s1);
			for(int l=0; l<s1.length(); l++) {
				if(checkHashMap.containsKey(s1.charAt(l))) {
					checkHashMap.put(s1.charAt(l), checkHashMap.get(s1.charAt(l))+1);
				}
				else {

					checkHashMap.put(s1.charAt(l), 1);
				}
			}
			for(int j=i+1; j<anagrams.length; j++) {
				String s2 = anagrams[j];
				if(s2.compareTo("A") == 0 || s1.length() != s2.length())continue;
				checkHashMap1.clear();
				flag = false;
				for(int l=0; l<s2.length(); l++) {
					if(checkHashMap1.containsKey(s2.charAt(l))) {
						checkHashMap1.put(s2.charAt(l), checkHashMap1.get(s2.charAt(l))+1);
					}
					else {
						checkHashMap1.put(s2.charAt(l), 1);
					}
				}
				for(Entry<Character, Integer> e: checkHashMap.entrySet()) {
					if(checkHashMap.get(e.getKey()) != checkHashMap1.get(e.getKey())) {
						flag = true;
						break;
					}
				}
				
				
				if(flag ==false) {
					anagramList.add(s2);
					anagrams[j] = "A";
				}
			}
			resuList.add(anagramList);
		}
		
		System.out.println(resuList);
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] anagramStrings = {"", "aa", "a", "aa", "", "a", ""};
		
		groupAnagrams(anagramStrings);
	}

}
