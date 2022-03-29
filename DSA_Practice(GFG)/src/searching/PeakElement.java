package searching;

public class PeakElement {

	public static int findPeakEmenet(int array[], int low, int high) {
		
		int result = -1;
		if(array.length == 2) {
			if(array[0] >= array[1])return 0;
			return 1;
		}
		else {
			int mid = (low+high)/2;
			while(low <= high) {
				mid = (low+high)/2;
				if(low == high)return mid;	
				if(mid == 0) {
					if(array[mid] > array[mid+1])return mid;
					else return mid+1;
				}
					
				else if(mid == array.length-1) {
					if(array[mid] > array[mid-1])return mid;
					else return mid-1;
				}
				else if(array[mid] > array[mid-1] && array[mid] > array[mid+1]) {
					result = mid;
					break;
				}
				else if(array[mid-1] < array[mid+1])low = mid+1;
				else high = mid-1;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int array[] = {1, 2, 3, 4, 5, 6};
		System.out.println(findPeakEmenet(array, 0, array.length));

	}

}
