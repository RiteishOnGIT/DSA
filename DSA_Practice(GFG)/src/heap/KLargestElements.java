package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestElements {

	public static void main(String[] args) {
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>(List.of(1, 5, 2, 8, 6, 10));
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		int k = 2;
		int i=0; 
		while(i != k) {
			pq.add(arrayList.get(i));
			i++;
		}
		for(i=k; i<arrayList.size(); i++) {
			if(arrayList.get(i) > pq.peek()) {
				pq.poll();
				pq.add(arrayList.get(i));
			}
		}
		
		System.out.println(pq);
		
	}

}
