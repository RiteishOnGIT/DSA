package sorting;

public class MergeSort {

	
	public static int[] mergeSort(int array[], int low, int high) {
		
		if(low >= high)return array;
		
		else {
			int mid = (low+high)/2;
			
			mergeSort(array, low, mid);
			mergeSort(array, mid+1, high);
			array =  MergeFunction.mergeTwoArrays(array, low, mid, high);

			return array;
		}
		
	}
	
	
	
	
	public static int [] mergeDriver(int array[]) {
		return mergeSort(array, 0, array.length);
	}
	
	
	
	public static void main(String[] args) {
		int array[] = {5, 10, 8, 20, 18, 2};
		System.out.println(mergeDriver(array));

	}

}
