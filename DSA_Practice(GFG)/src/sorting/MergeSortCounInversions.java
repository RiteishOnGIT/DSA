package sorting;

public class MergeSortCounInversions {

	
	public static int mergeSort(int array[], int low, int high) {
		
		if(low >= high)return 0;
		
		else {
			int mid = (low+high)/2;
			int count =0;
			count+= mergeSort(array, low, mid);
			count +=mergeSort(array, mid+1, high);
			count+= MergeFunction.mergeTwoArrays(array, low, mid, high);
			return count;
		}
		
	}
	
	
	
	
	public static int mergeDriver(int array[]) {
		return mergeSort(array, 0, array.length-1);
	}
	
	
	
	public static void main(String[] args) {
		int array[] = {5, 20, 18 ,1, 2, 3, 4, 12, 2121, 213 ,3};
		System.out.println(mergeDriver(array));
		for(int i=0; i<array.length; i++)System.out.println(array[i]);

	}

}
