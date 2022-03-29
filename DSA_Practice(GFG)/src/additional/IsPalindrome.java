package additional;

public class IsPalindrome {
	
	
	public static boolean isPalindrome(String s) {
		
		s = s.toLowerCase();
		String newString = "";
		for(int i=0; i<s.length(); i++) {
			if((s.charAt(i) >=97 && s.charAt(i) <= 122)|| (s.charAt(i) >=48 && s.charAt(i)<=57)) {
				newString += s.charAt(i);
			}
		}
		
		int i=0, j=newString.length()-1;
		while(i <= j) {
			if(newString.charAt(i) != newString.charAt(j))return false;
			i++; j--;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
		System.err.println(isPalindrome("0P"));
	}
	
	
}
