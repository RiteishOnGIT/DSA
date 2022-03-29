package strings;

public class LongestSubstringWithDistinctCharacters {
	
	
	static int getLargestWindows(String s) {
		
		int windowSize=0;
		int result = 0;
		int windowStart = 0;
		int i=0;
		int array[] = new int[256];
		while( i <s.length()) {
			
			if( array[s.charAt(i)]  == 0) {
				windowSize++;
				array[s.charAt(i)]++;
				i++;
				
			}
			else if(array[s.charAt(i)] > 0) {
				
				while(windowStart < s.length() && s.charAt(i) != s.charAt(windowStart)) {
					array[s.charAt(windowStart)]--;
					windowStart++;
					windowSize--;
					if(windowStart > s.length())break;
				}

				array[s.charAt(windowStart)]--;
				windowStart++;
				windowSize--;
				
			}
			result = Math.max(windowSize, result);
		}
		return result;
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println(getLargestWindows("geeksforgeeks"));
		
	}
	
	
}
