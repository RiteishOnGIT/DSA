package sorting;

public class LomutoPartition {

	public static void swap(int array[], int i, int j) {
		
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	
	public static int lomutoPartition(int array[], int a, int b) {
		
		int low = a-1;
		int high = b;
		int pivot = array[high];
		
		
		for(int i=a; i<=b; i++) {
			
			if(array[i] < pivot) {
				low++;
				swap(array, low, i);
			}
			
		}
		swap(array, low+1, high);
		return low+1;
	}
	
	
	
	
	public static void main(String[] args) {
		
		int array[] = {10, 80, 30, 90, 40, 50, 70};
		System.out.println(lomutoPartition(array, 0, array.length-1));
		
	}
	
}
