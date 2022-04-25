package strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;


class MySet {
	Integer frequency;
	Character alphabet;
	
	public MySet(Integer frequency, Character alphabet) {
		this.frequency = frequency;
		this.alphabet = alphabet;
	}
	
	@Override
	public String toString() {
		return frequency+" "+alphabet;
	}
}


public class NoRepeatingCharactersAreAdjcent {
	
	public static int noRepeatingChacartersAreAdjacent(String s) {
		
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		
		for(int i=0; i<s.length(); i++) {
			if(hm.get(s.charAt(i)) == null) {
				hm.put(s.charAt(i), 1);
			}
			else {
				hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
			}
		}
		
		Comparator<MySet> c = (obj1, obj2)->{
			if(obj1.frequency <= obj2.frequency)return 1;
			else return -1;
		};
		
		PriorityQueue<MySet> priorityQueue = new PriorityQueue<MySet>(c);
		for(Entry<Character, Integer> e: hm.entrySet()) {
			priorityQueue.add(new MySet(e.getValue(), e.getKey()));
		}
		String newString = "";
		MySet mySet = null;
		while(priorityQueue.isEmpty() == false) {
			mySet = priorityQueue.poll();
			MySet mySet2 = priorityQueue.poll();
			if(mySet2 == null)break;
			newString += mySet.alphabet;
			newString += mySet2.alphabet;
			mySet.frequency--;
			mySet2.frequency--;
			if(mySet.frequency != 0) {
				priorityQueue.add(mySet);
			}
			if(mySet2.frequency != 0) {
				priorityQueue.add(mySet2);
			}
		}
		while(mySet.frequency != 0) {
			newString+=mySet.alphabet;
			mySet.frequency--;
		}
		System.out.println(newString);
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(noRepeatingChacartersAreAdjacent("aaaabbcdddddddd"));
	}
	
}
