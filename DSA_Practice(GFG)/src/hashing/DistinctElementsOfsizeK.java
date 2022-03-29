package hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class DistinctElementsOfsizeK {

	public static ArrayList<Integer> getDistincts(int array[], int n, int k){
		
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		int x = 0 , j = 0;
		while(x < k) {

			if( hashMap.containsKey(array[x])) {
				hashMap.put(array[x], hashMap.get(array[x])+1);
			}
			else {
				hashMap.put(array[x], 1);
			}
			x++;
		}
		resultList.add(hashMap.size());
		for(int i=k; i<n; i++) {
			if(hashMap.containsKey(array[i]) == false) {
				hashMap.put(array[i], 1);
			}
			else {
				hashMap.put(array[i], hashMap.get(array[i])+1);
			}
			
			if(hashMap.get(array[j]) == 1) {
				hashMap.remove(array[j]);
			}
			else {
				hashMap.put(array[j], hashMap.get(array[j])-1);
			}
			resultList.add(hashMap.size());
			j++;
			
		}
		return resultList;
		
	}

	
	public static void main(String[] args) {
		
		int array[] = {4, 1, 1, 2 ,3, 4, 5};
		
		 System.out.println(getDistincts(array, array.length, array.length));

	}

}
