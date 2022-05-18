package arrays;

public class IncreasingAndDecreasing {
	
	static int search( int array[], int low, int high) {
		
		if(low >= high)return low;
		
		int mid = (low+high)/2;
		if(mid == 0 || mid == array.length-1)return mid;
		if(array[mid] > array[mid-1] && array[mid] > array[mid+1])return mid;
		else if(array[mid] > array[mid-1] && array[mid] < array[mid+1]) {
			return search(array, mid+1, high);
		}
		else {
			return search(array, low, mid-1);
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int array[] = {6,5,4,3,2,1};
		System.out.println(search(array, 0, array.length-1));
		
	}
}
