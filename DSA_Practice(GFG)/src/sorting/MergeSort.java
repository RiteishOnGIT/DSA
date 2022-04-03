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
		return mergeSort(array, 0, array.length-1);
	}
	
	
	
	public static void main(String[] args) {
		int array[] = {5, 20, 18 ,1, 2, 3, 4, 12, 2121, 213 ,3};
		System.out.println(mergeDriver(array));
		for(int i=0; i<array.length; i++)System.out.println(array[i]);

	}

}
