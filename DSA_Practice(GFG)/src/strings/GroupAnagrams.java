package strings;

import java.util.ArrayList;
import java.util.List;

public class GroupAnagrams {
	
	
	//THIS CODE WILL GIVE TLE BUT THIS CODE RUNS FINE 
	//ANOTHER APPROACH IS SORT EVERY STRING AND PUSH THAT TO HASHMAP AND RETURN THE HASHMAP OF< STRING, ArrayLIST<STRING> >
	
	
	public static void groupAnagrams(String[] anagrams) {
		
		List<List<String>>resuList = new ArrayList<List<String>>();
		
		for(int i=0; i<anagrams.length; i++) {
			int check[] = new int[26];
			boolean flag = false;
			String s1 = anagrams[i];
			List<String>anagramList = new ArrayList<String>();
			if(s1.compareTo("A") == 0)continue;
			anagramList.add(s1);
			for(int l=0; l<s1.length(); l++)check[s1.charAt(l)- 'a']++;
			for(int j=i+1; j<anagrams.length; j++) {
				String s2 = anagrams[j];
				if(s2.compareTo("A") == 0)continue;
				flag = false;
				int check1[] = new int[26];
				for(int x =0; x<s2.length(); x++)check1[s2.charAt(x)- 'a']++;
				
				for(int x=0; x<26; x++) {
					if(check[x] !=check1[x]) {
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
		String[] anagramStrings = {"", "aa", "", "aa", "a", ""};
		
		groupAnagrams(anagramStrings);
	}

}
