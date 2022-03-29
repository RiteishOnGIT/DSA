package sorting;

import java.util.Arrays;

public class MaximumNumberOfEvents {

	public static int findMax(int arr[][]) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(arr[i][0] > arr[i][1]) {
				max = Math.max(max, arr[i][0]);
			}
			else {
				max = Math.max(max, arr[i][1]);
			}
		}
		return max;
	}
	
	public static boolean parityCheck(int array[], int low, int high) {
		
		while(low <= high) {
			if(array[low] != -1 || array[high] != -1)return false;
			low++;
			high--;
		}
		return true;
	}
	
	public static int numberOfEvents(int array[][]) {
		
		int max = findMax(array);
		
		Arrays.sort(array, (a, b)->{
			if(a[1]-a[0] < b[1]-b[0]) {
				return -1;
			}
			else if(a[1]-a[0] > b[1]-b[0]) {
				return 1;
			}
			else {
				if(a[0] < b[0]) {
					return -1;
				}
				else if(a[0] > b[0]) {
					return 1;
				}
				else {
					if(a[1] < b[1])return -1;
					if(a[1] > b[1])return 1;
					return 0;
				}
			}
		});
		
		System.out.println(max);
		
		int parity[] = new int[max+1];
		for(int i=0; i<parity.length; i++)parity[i] = -1;
		
		int result = 0;
		for(int i=0; i<array.length; i++) {
			
			if(parityCheck(parity, array[i][0]+1, array[i][1]-1)) {
				parity[array[i][0]] = array[i][0];
				parity[array[i][1]] = array[i][1];
				result ++;
			}
			
		}
		
		
		return result;
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		int array[][]  = {{1,1}, {2,6}, {2,2}, {5,5}, {5,9}, {5,7}, {7, 9}};

		System.out.println(numberOfEvents(array));
		
	}

}
