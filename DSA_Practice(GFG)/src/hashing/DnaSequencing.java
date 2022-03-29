package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class DnaSequencing {
	
	
	public static ArrayList<String> getAllRepeatingDNA(String s){
		
		
		if(s.length() < 10)return new ArrayList<String>();
		
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		
		String res = s.substring(0, 10);
		
		hashMap.put(res, 1);
		for(int i=1; i<=s.length()-10; i++) {
			res = s.substring(i, i+10);
			
			if(hashMap.containsKey(res)) {
				hashMap.put(res, hashMap.get(res)+1);
				
			}
			else {
				hashMap.put(res, 1);
			}
				
		}
		
		ArrayList<String>result = new ArrayList<String>();
		
		for(Entry<String, Integer> e: hashMap.entrySet()) {
			
			if(e.getValue() > 1 ? true: false) {
				result.add(e.getKey());
			}
		}
		
		return result;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(getAllRepeatingDNA("AAAAAAAAAAA"));	
	}
	
	
}
