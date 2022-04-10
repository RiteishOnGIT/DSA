package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;

class myElements implements Comparable<myElements> {

	String string;
	Integer integer;

	public myElements(String s, Integer i) {
		string = s;
		integer = i;
	}

	@Override
	public String toString() {
		return string + " " + integer;
	}

	@Override
	public int compareTo(myElements o) {

		if (this.integer > o.integer)
			return -1;
		else if (this.integer < o.integer)
			return 1;
		else {
			if (this.string.compareTo(o.string) > 0)
				return 1;
			else if (this.string.compareTo(o.string) < 0)
				return -1;
			else
				return 0;
		}

	}
}

public class KFrequentyWords {

	static HashMap<String, Integer> elements = new HashMap<String, Integer>();

	public static void KFrequentStrings(ArrayList<String> strings) {

		for (int i = 0; i < strings.size(); i++) {
			if (elements.containsKey(strings.get(i))) {
				elements.put(strings.get(i), elements.get(strings.get(i)) + 1);
			} else {
				elements.put(strings.get(i), 1);
			}
		}

		int k = 2;

		ArrayList<myElements> results = new ArrayList<myElements>();

		for (Entry<String, Integer> e : elements.entrySet()) {

			results.add(new myElements(e.getKey(), e.getValue()));

		}

		PriorityQueue<myElements> pQueue = new PriorityQueue<myElements>(Collections.reverseOrder());
		int i = 0;

		while (k != 0) {
			pQueue.add(results.get(i));
			i++;
			k--;
		}

		for (; i < results.size(); i++) {

			if (pQueue.peek().integer < results.get(i).integer) {
				pQueue.poll();
				pQueue.add(results.get(i));
				
			}
			else if(pQueue.peek().integer == results.get(i).integer) {
				if(pQueue.peek().string.compareTo(results.get(i).string) > 0) {
					pQueue.poll();
					pQueue.add(results.get(i));
				}
			}
			
		}

		List<String> resultList = new ArrayList<String>();

		while (!pQueue.isEmpty()) {
			resultList.add(pQueue.poll().string);
		}
		Collections.reverse(resultList);
		System.out.println(resultList);
	}

	public static void main(String[] args) {

		ArrayList<String> strings = new ArrayList<String>(List.of("i","love","leetcode","i","love","coding"));
				KFrequentStrings(strings);

	}

}
