package recursion;

import java.util.ArrayList;
import java.util.HashMap;

public class PossibleWordsFromPhonedigits {

	
	public static void generateWords(ArrayList<String> result, int index, int N, int arr[], 
			HashMap<Integer, String> hm, String temp) {
		if(temp.length() == N) {
			result.add(temp);
			return;
		}
		if(index > N)return;
		String s = hm.get(arr[index]);
		for(int i=0; i<s.length(); i++) {
			generateWords(result, index+1 ,N, arr, hm, temp+s.charAt(i));
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> result = new ArrayList<String>();
		
		HashMap<Integer, String> numbers = new HashMap<Integer, String>();
		numbers.put(2, "abc");
		numbers.put(3, "def");
		numbers.put(4, "ghi");
		numbers.put(5, "jkl");
		numbers.put(6, "mno");
		numbers.put(7, "pqrs");
		numbers.put(8, "tuv");
		numbers.put(9, "wxyz");
		
		int arr[] = {3, 4, 5, 6, 7, 8, 9};
		generateWords(result, 0, 7, arr, numbers, "");
		System.out.println(result);

	}

}
