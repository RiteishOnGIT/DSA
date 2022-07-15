package tree;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.Map.Entry;

public class RelativeSorting {
	
	
	public static int[] relativeSorted(int a1[], int a2[]) {
		
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		for(int i=0; i<a1.length; i++) {
			if(map.get(a1[i]) == null) {
				map.put(a1[i], 1);
			}
			else {
				map.put(a1[i], map.get(a1[i])+1);
			}
		}
		
		
		HashSet<Integer> set = new HashSet<Integer>();
		int index = 0;
		for(int i=0; i<a2.length; i++) {
			if(!set.contains(a2[i])) {
				set.add(a2[i]);
				while(map.get(a2[i]) != null) {
					a1[index++] = a2[i];
					map.put(a2[i], map.get(a2[i])-1);
					if(map.get(a2[i]) == 0)map.remove(a2[i]);
				}
			}
		}
		if(!map.isEmpty()) {
			for(Entry<Integer, Integer> e: map.entrySet()) {
				int val = e.getValue();
				while(val >= 1) {
					a1[index++] = e.getKey();
					val--;
				}
			}
		}
		for(int i=0; i<a1.length; i++) {
			System.out.print(a1[i]+" ");
		}
		return a1;
	}
	
	
	
	public static void main(String[] args) {
		int a1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
		int a2 [] = {2,2,2,22,2};
		
		relativeSorted(a1, a2);
	}
	
}
