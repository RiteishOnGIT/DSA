package strings;

public class LongestPalindromicSubstring {

	public static String longestPalindromic(String s) {
		
		String longestString =s.charAt(0)+"";
		
		for(int i=0; i<s.length(); i++) {
			int j = i-1;
			
			int k = i+1;
			
			while(j >= 0) {
				if(s.charAt(i) != s.charAt(j)) {
					break;
				}
				j--;
			}
			while(k < s.length()) {
				if(s.charAt(i) != s.charAt(k)) {
					break;
				}
				k++;
			}
			
			while(j >=0 && k <s.length()) {
				if(s.charAt(j) == s.charAt(k)) {
					j--;
					k++;
				}
				else {
					break;
				}
			}
			j++;
			k--;
			if(k-j >= longestString.length()) {
				longestString = s.substring(j, k+1);
			}
			
		}
		
		return longestString;
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println(longestPalindromic("aaaaaaaaaaaaacvbcvbcvbcvaaaaaaaaaaaabbaaaaaaaaaaa"));
	}

}
