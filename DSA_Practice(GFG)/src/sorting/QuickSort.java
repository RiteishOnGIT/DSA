package sorting;

public class QuickSort {

	
	public static void quickSortLomuto(int array[], int low, int high) {
		
		if(low < high) {
			
			int p =  LomutoPartition.lomutoPartition(array, low, high);
			quickSortLomuto(array, low, p-1);
			quickSortLomuto(array, p+1, high);
		}	
	}
	
	
	public static void quickSortHoare(int array[], int low, int high) {
		
		if(low < high) {
			
			int p = Hoarespartition.hoarePartition(array, low, high);
			quickSortHoare(array, low, p);
			quickSortHoare(array, p+1, high);
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		
		int array[] = {10, 80, 30, 90, 40, 50, 70};
		//quickSortLomuto(array, 0, array.length-1);
		quickSortHoare(array, 0, array.length-1);
		for(int a: array)System.out.print(a+" ");
		
	}
	
}
