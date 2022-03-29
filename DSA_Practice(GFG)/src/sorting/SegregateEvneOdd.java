package sorting;

public class SegregateEvneOdd {
	
	
	public static void evenOdd( int arr[], int low, int high) {
		
		int i = low-1;
		int j = high+1;
		
		while(true) {
			
			do { 
				i++; 
				if(i >= j)break;
			}while(arr[i] % 2 == 0);
			do { 
				j--; 
				if(i >= j)break;
			}while(arr[j] %2 != 0);
			
			if(i >= j)break;
			LomutoPartition.swap(arr, i, j);
		}
		
	}
	
	public static void main(String[] args) {
	
		int array[] = {0, 2};
		evenOdd(array, 0, array.length-1);
		
		for(int a: array)System.out.print(a+" ");
		
	}
	
}
