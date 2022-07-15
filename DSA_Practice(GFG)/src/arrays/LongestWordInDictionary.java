package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionary {
	
	
	  public static int stringCompare(String str1, String str2)
	    {
	  
	        int l1 = str1.length();
	        int l2 = str2.length();
	        int lmin = Math.min(l1, l2);
	  
	        for (int i = 0; i < lmin; i++) {
	            int str1_ch = (int)str1.charAt(i);
	            int str2_ch = (int)str2.charAt(i);
	  
	            if (str1_ch != str2_ch) {
	                return str1_ch - str2_ch;
	            }
	        }
	  
	        if (l1 != l2) {
	            return l1 - l2;
	        }
	  
	        else {
	            return 0;
	        }
	    }
	  
	public static boolean isFine(int arr[]) {
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		if(sum == 0)return true;
		return false;
	}

	private static int[] fillTheArray(String string) {
		
		int arr[] = new int[27];
		for(int i=0; i<string.length(); i++)arr[string.charAt(i)-'a']++;
		
		return arr;
	}
	
	public static String findLongestWord(String s, List<String>words) {
		
		String max_str = "";
		
		for(int i=0; i<words.size(); i++) {
			
			int arr[] = fillTheArray(words.get(i));
			for(int j=0; j<s.length(); j++) {
				if(arr[s.charAt(j)- 'a'] != 0) arr[s.charAt(j)- 'a']--;
			}
			
			if(isFine(arr)) {
				String str = words.get(i);
				if (str.length() > max_str.length() || (str.length() == max_str.length() && str.compareTo(max_str) < 0)) {
	                    max_str = str;
				}
				
			}
		}
		return max_str;
		
		
		
	}
	
	


	public static void main(String[] args) {
		String s = "abpcplea";
		List<String> wordStrings = new ArrayList<String>(Arrays.asList("a","b","c"));
		System.out.println(findLongestWord(s, wordStrings));
	}
	
	
}
