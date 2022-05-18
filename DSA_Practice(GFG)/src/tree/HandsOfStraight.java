package tree;

import java.util.Collections;
import java.util.TreeMap;

public class HandsOfStraight {

	public static boolean isNStraightHand(int [] hand, int groupSize) {
		
		TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(Collections.reverseOrder());
		
		for(int i=0; i<hand.length; i++) {
			if(treeMap.get(hand[i]) != null) {
				treeMap.put(hand[i], treeMap.get(hand[i])+1);
			}
			else {
				treeMap.put(hand[i], 1);
			}
		}
		

		while(!treeMap.isEmpty()) {
			
			int a = treeMap.firstKey();
			int x  = groupSize;
			while(x != 0) {
				if(treeMap.get(a)== 1)treeMap.remove(a);
				else treeMap.put(a, treeMap.get(a)-1);
				if(x == 1)break;
				if(treeMap.get(a-1) == null)return false;
				else {
					a= a-1;
				}
				x--;
			}	
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
		int array[] = {1,2,3,4,5,6,7,8,11,12,56,57};
		System.out.println(isNStraightHand(array, 2));
		
	}

}
