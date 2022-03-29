package sorting;

public class Hoarespartition {

	
	public static int hoarePartition(int array[], int low, int high ) {
		
		int i=low-1;
		int j = high+1;
		int pivot = array[low];
		
		while(true) {
			do {
				i++;
			}while(array[i] < pivot);
			
			do {
				j--;
			}while(array[j] > pivot);
			
			if(i >= j)return j;
			LomutoPartition.swap(array, i, j);
			
			
		}
	}
	
	
	
	public static void main(String[] args) {
		
		int array[] = {10, 80, 30, 90, 40, 50, 70};
		System.out.println(hoarePartition(array, 0, array.length-1));
		
	}
	
}
