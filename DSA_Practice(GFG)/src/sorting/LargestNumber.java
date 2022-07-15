package sorting;

import java.util.Arrays;

public class LargestNumber {
	
	public static void main(String[] args) {
		String arr[] = {"3", "30", "34", "5", "9"};
		
		
		
		Arrays.sort(arr, (s1, s2)->{
			int i=0;
			int j=0;
			while(i < s1.length() && j < s2.length()) {
				if(s1.charAt(i) < s2.charAt(j)) {
					return 1;
				}
				else if(s1.charAt(i) > s2.charAt(j)) {
					return -1;
				}
				else {
					if(s1.length() > s2.length())return 1;
					i++;
					j++;
				}
			}
			return 0;
		}); 
		String res = "";
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
			res += arr[i];
		}
		System.out.println(res);
	}
	
}
