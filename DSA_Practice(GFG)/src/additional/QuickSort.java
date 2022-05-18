package additional;

public class QuickSort {
	
	public static Integer hoaresPArtition(int array[], int low, int high) {
		int pivot = array[low];
		int i=low-1;
		int j=high+1;
		
		while(true) {
			
			do {
                i++;
            } while (array[i] < pivot);
 
            do {
                j--;
            } while (array[j] > pivot);
            if (i >= j)
                return j;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
		}
		
	}
	
	
	public static void quickSort(int array[], int low, int high) {
		
		if(low>= high)return;
		
		int partiton = hoaresPArtition(array, low, high);
		quickSort(array, low, partiton);
		quickSort(array, partiton+1, high);
		
		
	}
	
	
	public static int findKthLargest(int array[], int low, int high, int elemnt) {
		
		int index = hoaresPArtition(array, low, high);
		if(index == elemnt)return index;
		if(index < elemnt) {
			return findKthLargest(array, index, high, elemnt);
		}
		else{
			return findKthLargest(array, low, index, elemnt);
		}
		
	}
	
	public static void main(String[] args) {
		int arr[] = {9,1,2,3,4,5,5};
		//System.out.println(hoaresPArtition(arr, 0, arr.length));
		
		//System.out.println(arr[findKthLargest(arr, 0, arr.length, 2)]);
		quickSort(arr, 0, arr.length-1);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
}
