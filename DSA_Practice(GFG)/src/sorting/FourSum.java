package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

	public static void main(String[] args) {
		
		int arr[] = {1000000000,1000000000,1000000000,1000000000};
		
		Arrays.sort(arr);
		Set<ArrayList<Integer>> resList = new HashSet<ArrayList<Integer>>();
		int target = -294967296;
		long temp = target;
		for(int i=0; i<arr.length-3; i++) {
			temp -= arr[i];
			for(int j=i+1; j<arr.length-2; j++) {
				temp -= arr[j];
				
				int k = j+1, l = arr.length-1;
				
				while(k < l) {
					if(temp > arr[k] + arr[l]) {
						k++;
					}
					else if(temp < arr[k] + arr[l]) {
						l--;
					} 
					else if(temp == arr[k] + arr[l]) {
						//System.out.println(arr[i]+"  "+arr[j]+" "+ arr[k]+"  "+arr[l]);
						resList.add(new ArrayList<Integer>(List.of(arr[i], arr[j], arr[k], arr[l])));
						l--;
						k++;
					}
				}
				temp+= arr[j];
			}
			temp+= arr[i];
		}
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		resList.forEach(element->resultList.add(element));
		System.out.println(resultList);
	}

}
