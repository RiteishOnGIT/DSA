package heap;

import java.util.PriorityQueue;

public class KthLargestElementinStream {
	
	public static void kthLargest(int array[], int k) {
		
		int i=0, j =0; 
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		while(i < k) {
			priorityQueue.add(array[i]);
			i++;
			j++;
			if(i < k) {
				System.out.print(-1+" ");
			}
		}
		
		j--;
		while(priorityQueue.isEmpty() == false && j < array.length) {
			
			if(i < array.length) {
				if(priorityQueue.peek() < array[i]) {
					System.out.print(priorityQueue.poll()+" ");
					if(i<array.length) {
						priorityQueue.add(array[i]);
					}
				}
				else {
					System.out.print(priorityQueue.peek()+" ");
				}
			}
			else {
				System.out.println(priorityQueue.poll());
			}
			j++;
			i++;
		}
		
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		int array[] = {1, 2 ,3, 4, 5, 6};
		kthLargest(array, 4);
	}
	
}
