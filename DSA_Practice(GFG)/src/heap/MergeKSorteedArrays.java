package heap;

import java.util.ArrayList;
import java.util.PriorityQueue;


class Pair implements Comparable<Pair>{
	Integer element;
	Integer row;
	Integer column;
	
	public Pair(Integer element, Integer row, Integer column) {
		this.element = element;
		this.row = row;
		this.column = column;
	}
	
	@Override
	public int compareTo(Pair o) {
		return this.element.compareTo(o.element);
	}
	
	@Override
	public String toString() {
		return this.element+" "+this.row+" "+this.column;
	}
}

public class MergeKSorteedArrays {
	
	public static ArrayList<Integer> mergeKsorted(int [][] array, int k){
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		PriorityQueue<Pair> priorityQueue = new PriorityQueue<Pair>();
		for(int i=0; i<k; i++)priorityQueue.add(new Pair(array[i][0], i, 0));
		
		while(!priorityQueue.isEmpty()) {
			
			Pair pair = priorityQueue.poll();
			System.out.println(pair);
			result.add(pair.element);
			if(pair.column+1 < k) {
				priorityQueue.add(new Pair(array[pair.row][pair.column+1], pair.row, pair.column+1));
			}
			
			
		}
		System.err.println(result);
		
		return result;
		
	}
	
	
	
	public static void main(String[] args) {
		
		int arr[][]={{5, 6},{1, 2}};
		
		mergeKsorted(arr, 2);
	}
	
	
}
