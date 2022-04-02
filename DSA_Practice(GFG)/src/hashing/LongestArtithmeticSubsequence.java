package hashing;

import java.util.HashMap;

public class LongestArtithmeticSubsequence {

	
	public static void longestArithmetic(int array[]) {
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		int difference  = 1;
		int result = 1;
		for(int i=0; i<array.length; i++) {
			if(hashmap.containsKey(array[i] - difference)) {
				int var = array[i];
				array[i] = array[hashmap.get(array[i] - difference)] +1;
				hashmap.put(var, i);
				result = Math.max(result, array[i]);
				
			}
			else if(hashmap.containsKey(array[i] - difference) == false) {
				hashmap.put(array[i], i);
				array[i] = 1;
			}
		}
		System.out.println(result);
	}
	
	
	
	
	public static void main(String[] args) {
		
		int array[] = {1,5,7,8,5,3,4,2,1};
		longestArithmetic(array);
	}

}
