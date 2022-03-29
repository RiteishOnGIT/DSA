package sorting;

public class MergeFunction {

	
	public static int[] mergeTwoArrays(int [] array, int low, int mid, int high) {
		int k=0;
		int temp[] = new int [high-low+1];
		int x=low, y= mid;
		
		while(x<=mid && y<high) {
			
			if(array[x] <= array[y]) {
				temp[k++] = array[x++];
			}
			else {
				temp[k++] = array[y++];
			}
			
		}
		
		while(x <= mid) {
			temp[k++] = array[x++];
			if(x == mid)break;
		}
		while(y < high)temp[k++] = array[y++];
		
		k=0;
		for(int i=low; i<high; i++) {
			array[i] = temp[k++];
		}
		return array;
		
	}
	
	public static void main(String[] args) {
		
		int array[] = {6, 5};
		
		array = mergeTwoArrays(array, 0, ((array.length)/2), array.length);
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
		
	}

}
