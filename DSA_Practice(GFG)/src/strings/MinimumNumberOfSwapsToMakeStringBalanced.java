package strings;

import java.util.ArrayDeque;

public class MinimumNumberOfSwapsToMakeStringBalanced {
	
	public static int minSwaps(String s) {
		
		//we can just replace arrayDeque with just a variable here 
		
		ArrayDeque<Character> arrayDeque = new ArrayDeque<Character>();
		
		int result = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '[') {
				arrayDeque.addFirst(s.charAt(i));
			}
			else if(s.charAt(i) == ']') {
				if(arrayDeque.isEmpty()) {
					result++;
				}
				else {
					arrayDeque.pollFirst();
				}
			}
		}
		if(result %2 == 0)return result/2;
		return 1+(result/2);
		
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(minSwaps("[[[[[[]]]]]]]]]]]]]]]]]]]]][[[[[[[[[[[[[[["));
	}
	
	
}
